package de.telran.telaran_project_dogs_owners.repository;

import de.telran.telaran_project_dogs_owners.entity.Dog;
import de.telran.telaran_project_dogs_owners.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Integer> {
    List<Dog> findAllByOwner(Owner owner);
    List<Dog> findAllByOwnerIsNull();

}
