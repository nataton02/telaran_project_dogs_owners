package de.telran.telaran_project_dogs_owners.service.impl;

import de.telran.telaran_project_dogs_owners.dto.OwnerRequestDTO;
import de.telran.telaran_project_dogs_owners.dto.OwnerResponseDTO;
import de.telran.telaran_project_dogs_owners.entity.Dog;
import de.telran.telaran_project_dogs_owners.entity.Owner;
import de.telran.telaran_project_dogs_owners.repository.DogRepository;
import de.telran.telaran_project_dogs_owners.repository.OwnerRepository;
import de.telran.telaran_project_dogs_owners.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements IOwnerService {

    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private DogRepository dogRepository;


    @Override
    public void createOwner(OwnerRequestDTO request) {
        ownerRepository.save(mapDtoToOwner(request));
    }

    @Override
    public List<OwnerResponseDTO> getAllOwners() {
        return ownerRepository.findAll().stream()
                .map(this::mapOwnerToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OwnerResponseDTO getOwnerById(Integer id) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        List<Dog> dogs = dogRepository.findAllByOwner(owner);
        OwnerResponseDTO response =  mapOwnerToDto(owner);
        response.setDogs(dogs);

        return response;
    }

    @Override
    public void toggleDogOwner(Integer ownerId, Integer dogId) {
        System.out.println("-----" + dogId);
        Owner owner = ownerRepository
                .findById(ownerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Dog dog = dogRepository
                .findById(dogId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if(dog.getOwner() != null && !dog.getOwner().getId().equals(ownerId)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

        if(dog.getOwner() == null) {
            dog.setOwner(owner);
            dog.setRegistrationDate(LocalDate.now());
        }
        else {
            dog.setOwner(null);
            dog.setRegistrationDate(null);
        }

        dogRepository.save(dog);
    }


    private Owner mapDtoToOwner(OwnerRequestDTO request) {
        return Owner.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .dateOfBirth(request.getDateOfBirth())
                .build();
    }

    private OwnerResponseDTO mapOwnerToDto(Owner owner) {
        return OwnerResponseDTO.builder()
                .id(owner.getId())
                .firstName(owner.getFirstName())
                .lastName(owner.getLastName())
                .dateOfBirth(owner.getDateOfBirth())
                .build();
    }






}
