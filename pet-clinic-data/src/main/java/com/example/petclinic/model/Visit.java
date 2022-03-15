package com.example.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter //lombok annotation
@Getter  //lombok annotation
@NoArgsConstructor //lombok annotation
@AllArgsConstructor //lombok annotation
@Builder //lombok annotation
@Table(name = "visits")
public class Visit extends BaseEntity{

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
}
