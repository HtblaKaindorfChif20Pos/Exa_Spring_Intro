package at.kaindorf.jpaintro.pojos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Project: Exa_201_Spring-JPA-Intro_4CHIF
 * Created by: SF
 * Date: 15.11.2023
 * Time: 08:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Pet implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long petId;

  @NonNull
  private String name;
  @NonNull
  @Column(length=50)
  private String petType;
  @NonNull
  private LocalDate birthdate;
  @NonNull
  private Float weight;

//  @OneToOne(mappedBy = "pet", cascade = CascadeType.PERSIST)
  @ManyToOne
  @JoinColumn(name = "owner_id")
  @JsonBackReference
  private PetOwner owner;
}
