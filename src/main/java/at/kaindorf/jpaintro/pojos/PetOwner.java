package at.kaindorf.jpaintro.pojos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: Exa_201_Spring-JPA-Intro_4CHIF
 * Created by: SF
 * Date: 15.11.2023
 * Time: 08:57
 */
@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class PetOwner implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String ownerId;
  @NonNull
  @Column(length = 100)
  private String name;

  @OneToMany(mappedBy = "owner", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//  @JoinColumn(name = "owner_id")
  @JsonManagedReference
  private List<Pet> petList = new ArrayList<>();

  public void addPet(Pet pet) {
    pet.setOwner(this);
    petList.add(pet);
  }

//  @OneToOne(cascade = CascadeType.PERSIST)
//  @JoinColumn(name = "pet_id")
//  @ToString.Exclude
//  private Pet pet;

  @ManyToMany(mappedBy = "ownerList")
  private List<Address> addressList = new ArrayList<>();

  public void addAddress(Address address) {
    addressList.add(address);
  }

}
