package at.kaindorf.jpaintro.database;

import at.kaindorf.jpaintro.pojos.Pet;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project: Exa_201_Spring-JPA-Intro_4CHIF
 * Created by: SF
 * Date: 15.11.2023
 * Time: 09:07
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

  List<Pet> findAllByPettype(String petType, Pageable page);

  @Query("SELECT p FROM Pet p WHERE p.owner.name = :ownerName")
  List<Pet> findPetsByOwnerName(String ownerName);
}
