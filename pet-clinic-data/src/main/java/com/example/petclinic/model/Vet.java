package com.example.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter //lombok annotation
@Getter  //lombok annotation
@NoArgsConstructor //lombok annotation
@AllArgsConstructor //lombok annotation
@Builder //lombok annotation
@Table(name = "vets")
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specilities = new HashSet<>();
}
