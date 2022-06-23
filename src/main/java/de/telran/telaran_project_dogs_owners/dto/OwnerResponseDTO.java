package de.telran.telaran_project_dogs_owners.dto;

import de.telran.telaran_project_dogs_owners.entity.Dog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class OwnerResponseDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private List<Dog> dogs;

}
