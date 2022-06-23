package de.telran.telaran_project_dogs_owners.service;

import de.telran.telaran_project_dogs_owners.dto.OwnerRequestDTO;
import de.telran.telaran_project_dogs_owners.dto.OwnerResponseDTO;

import java.util.List;

public interface IOwnerService {

    void createOwner(OwnerRequestDTO request);

    List<OwnerResponseDTO> getAllOwners();

    OwnerResponseDTO getOwnerById(Integer id);

    void toggleDogOwner(Integer ownerId, Integer dogId);



}
