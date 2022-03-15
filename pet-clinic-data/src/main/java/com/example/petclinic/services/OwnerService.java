package com.example.petclinic.services;

import com.example.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CRUDService<Owner, Long>{

    Owner findByLastName(String lastName);
}