package at.kaindorf.jpaintro.database;

import at.kaindorf.jpaintro.pojos.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Project: Exa_201_Spring-JPA-Intro_4CHIF
 * Created by: SF
 * Date: 29.11.2023
 * Time: 08:31
 */
public interface PetOwnerRepository extends JpaRepository<PetOwner, String> {
}
