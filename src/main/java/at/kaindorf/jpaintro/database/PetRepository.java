package at.kaindorf.jpaintro.database;

import at.kaindorf.jpaintro.pojos.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Project: Exa_201_Spring-JPA-Intro_4CHIF
 * Created by: SF
 * Date: 15.11.2023
 * Time: 09:07
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
