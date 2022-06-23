package de.telran.telaran_project_dogs_owners.dto;

import de.telran.telaran_project_dogs_owners.entity.Owner;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@AllArgsConstructor
@Data
public class DogRequestDTO {

    private String nickname;
    private String breed;
    private LocalDate dateOfBirth;
    private LocalDate registrationDate;
    private Owner owner;

}
