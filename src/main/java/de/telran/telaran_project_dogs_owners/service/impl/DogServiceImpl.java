package de.telran.telaran_project_dogs_owners.service.impl;

import de.telran.telaran_project_dogs_owners.dto.DogRequestDTO;
import de.telran.telaran_project_dogs_owners.dto.DogResponseDTO;
import de.telran.telaran_project_dogs_owners.entity.Dog;
import de.telran.telaran_project_dogs_owners.repository.DogRepository;
import de.telran.telaran_project_dogs_owners.service.IDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DogServiceImpl implements IDogService {

    @Autowired
    private DogRepository dogRepository;


    @Override
    public void createDog(DogRequestDTO request) {
        dogRepository.save(mapDtoToDog(request));

    }

    @Override
    public List<DogResponseDTO> getDogs(boolean isUnregistered) {
        if(isUnregistered)
            return dogRepository.findAllByOwnerIsNull().stream()
                    .map(this::mapDogToDto)
                    .collect(Collectors.toList());
        else return dogRepository.findAll()
                .stream()
                .map(this::mapDogToDto)
                .collect(Collectors.toList());
    }

    private Dog mapDtoToDog(DogRequestDTO request) {
        return Dog.builder()
                .nickname(request.getNickname())
                .breed(request.getBreed())
                .dateOfBirth(request.getDateOfBirth())
                .registrationDate(null)
                .owner(null)
                .build();
    }

    private DogResponseDTO mapDogToDto(Dog dog) {
        return DogResponseDTO.builder()
                .id(dog.getId())
                .nickname(dog.getNickname())
                .breed(dog.getBreed())
                .build();
    }

}
