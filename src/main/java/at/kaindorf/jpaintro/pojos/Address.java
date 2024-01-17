package at.kaindorf.jpaintro.pojos;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Exa_201_Spring-JPA-Intro_4CHIF
 * Created by: SF
 * Date: 10.01.2024
 * Time: 08:28
 */
@Entity
public class Address {
  @Id
  @GeneratedValue
  private Long addressId;

  @Column(length = 50)
  private String cityName;
  @Column(length = 100)
  private String streetName;

  @ManyToMany
  @JoinTable(name = "address_petowner",
      joinColumns = {@JoinColumn(name = "address_id")},
      inverseJoinColumns = {@JoinColumn(name = "petowner_id")}
  )
  private List<PetOwner> ownerList = new ArrayList<>();

  public void addPetOwner(PetOwner petOwner) {
    ownerList.add(petOwner);
  }

}
