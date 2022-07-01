package de.telran.telaran_project_dogs_owners.dto;

import de.telran.telaran_project_dogs_owners.entity.Owner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@Builder
public class DogResponseDTO {
    private Integer id;
    private String nickname;
    private String breed;
    private LocalDate registrationDate;
    private Owner owner;

}
