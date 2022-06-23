package de.telran.telaran_project_dogs_owners.service;

import de.telran.telaran_project_dogs_owners.dto.DogRequestDTO;
import de.telran.telaran_project_dogs_owners.dto.DogResponseDTO;

import java.util.List;

public interface IDogService {


    void createDog(DogRequestDTO request);

    //List<DogResponseDTO> getAllByOwnerId(Integer ownerId);

    //DogResponseDTO getDogById(Integer id);

    List<DogResponseDTO> getDogs(boolean isUnregistered);
}
