package de.telran.telaran_project_dogs_owners.controller;

import de.telran.telaran_project_dogs_owners.dto.OwnerRequestDTO;
import de.telran.telaran_project_dogs_owners.dto.OwnerResponseDTO;
import de.telran.telaran_project_dogs_owners.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {

    @Autowired
    private IOwnerService iOwnerService;

    @PostMapping("/owners")
    public void createOwner(@RequestBody OwnerRequestDTO request) {
        iOwnerService.createOwner(request);
    }

    @GetMapping("/owners")
    public List<OwnerResponseDTO> getAllOwners() {
        return iOwnerService.getAllOwners();
    }

    @GetMapping("/owners/{id}")
    public OwnerResponseDTO getOwnerById(@PathVariable("id") Integer id) {
        return iOwnerService.getOwnerById(id);
    }

    @PutMapping("/owners/{ownerId}/dogs/{dogId}")
    public void toggleDogOwner(@PathVariable("ownerId") Integer ownerId,
                               @PathVariable("dogId") Integer dogId) {
        iOwnerService.toggleDogOwner(ownerId, dogId);

    }


}
