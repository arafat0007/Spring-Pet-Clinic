package com.example.petclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter //lombok annotation
@Getter  //lombok annotation
@NoArgsConstructor //lombok annotation
@AllArgsConstructor //lombok annotation
@Builder //lombok annotation
@Table(name = "specialities")
public class Speciality extends BaseEntity{

    @Column(name = "description")
    private String description;
}
