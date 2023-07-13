package org.springframework.petclinicUtil;

// PetBuilder class using builder pattern to create Pet objects
// FOR CLASS org.springframework.samples.petclinic.model.Pet

import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.model.Owner;

import java.time.LocalDate;
import java.util.*;

public class PetBuilder {
    private String name;
    private LocalDate birthDate;
    private PetType type;
    private Owner owner;
    private List<Visit> visits;

    public PetBuilder() {
        this.name = "name";
        this.birthDate = LocalDate.of(2020, 1, 1);
        this.type = new PetType();
        this.owner = new Owner();
        this.visits = new ArrayList<Visit>();
    }

    public PetBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PetBuilder withBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public PetBuilder withType(PetType type) {
        this.type = type;
        return this;
    }

    public PetBuilder withOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public PetBuilder withVisits(List<Visit> visits) {
        this.visits = visits;
        return this;
    }

    public Pet build() {
        Pet pet = new Pet();
        pet.setName(name);
        pet.setBirthDate(birthDate);
        pet.setType(type);
        pet.setOwner(owner);
        pet.setVisits(visits);
        return pet;
    }
}
