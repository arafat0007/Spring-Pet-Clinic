package com.example.petclinic.bootstrap;

import com.example.petclinic.model.*;
import com.example.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0){
            LoadData();
        }
    }

    private void LoadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Arafat");
        owner1.setLastName("yasin");
        owner1.setAddress("koralia");
        owner1.setCity("chandpur");
        owner1.setTelephone("01676562232");

        Pet arafatsDog = new Pet();
        arafatsDog.setPetType(saveDogPetType);
        arafatsDog.setOwner(owner1);
        arafatsDog.setBirthDate(LocalDate.now());
        arafatsDog.setName("billu");
        owner1.getPets().add(arafatsDog);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Afrina");
        owner2.setLastName("Anwar");
        owner2.setAddress("mirpur");
        owner2.setCity("dhaka");
        owner2.setTelephone("01521210703");

        Pet afrinasCat = new Pet();
        afrinasCat.setPetType(saveCatPetType);
        afrinasCat.setOwner(owner2);
        afrinasCat.setBirthDate(LocalDate.now());
        afrinasCat.setName("millu");
        owner2.getPets().add(afrinasCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(afrinasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Smelly cat from friends");

        visitService.save(catVisit);

        System.out.println("loaded owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Ismail");
        vet1.setLastName("hossain");
        vet1.getSpecilities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Anwar");
        vet2.setLastName("Mumit");
        vet2.getSpecilities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("loaded vets....");
    }
}
