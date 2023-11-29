package at.kaindorf.jpaintro.database;

import at.kaindorf.jpaintro.pojos.Pet;
import at.kaindorf.jpaintro.pojos.PetOwner;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
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
    log.info("Init pets table ...");
    Pet pet1 = new Pet("garfield", "cat", LocalDate.of(2014,4,14), 3.5f);
    Pet pet2 = new Pet("odie", "dog", LocalDate.of(2016,5,18), 1.5f);
    PetOwner owner1 = new PetOwner("John");
    owner1.addPet(pet1);
    owner1.addPet(pet2);
    petOwnerRepo.save(owner1);
  }
}
