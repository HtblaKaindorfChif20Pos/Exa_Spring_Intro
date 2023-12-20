package at.kaindorf.jpaintro.database;

import at.kaindorf.jpaintro.pojos.Pet;
import at.kaindorf.jpaintro.pojos.PetOwner;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * Project: Exa_201_Spring-JPA-Intro_4CHIF
 * Created by: SF
 * Date: 15.11.2023
 * Time: 09:10
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class InitDatabase {

  private final PetRepository petRepo;
  private final PetOwnerRepository petOwnerRepo;

  @PostConstruct
  public void initPets() {

    Sort sorting = Sort.by("birthdate").descending().and(Sort.by("name"));
    List<Pet> list1 =  petRepo.findAll();
    List<Pet> list2 =  petRepo.findAll(Sort.by("name").descending().and(Sort.by("birthdate")));
    Pageable pageable = PageRequest.of(10, 5, Sort.by("name"));
    Pageable page = PageRequest.of(1,10, sorting);
    List<Pet> petsByType = petRepo.findAllByPettype("Cat", page);

    log.info("Init pets table ...");
    Pet pet1 = new Pet("garfield", "cat", LocalDate.of(2014,4,14), 3.5f);
    Pet pet2 = new Pet("odie", "dog", LocalDate.of(2016,5,18), 1.5f);
    PetOwner owner1 = new PetOwner("John");
    owner1.addPet(pet1);
    owner1.addPet(pet2);
    petOwnerRepo.save(owner1);
  }
}
