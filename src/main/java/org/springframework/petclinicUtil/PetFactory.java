// PetFactory class using Factory pattern to create Pet objects
// FOR CLASS org.springframework.samples.petclinic.model.Pet
//
 package org.springframework.petclinicUtil;
 
    import org.springframework.samples.petclinic.model.Pet;
    import org.springframework.samples.petclinic.model.PetType;
    import org.springframework.samples.petclinic.model.Visit;
    import org.springframework.samples.petclinic.model.Owner;
         
    import java.time.LocalDate;
    import java.util.*;
    
    public class PetFactory {
        public static Pet createPet(String name, LocalDate birthDate, PetType type, Owner owner, List<Visit> visits) {
            Pet pet = new Pet();
            pet.setName(name);
            pet.setBirthDate(birthDate);
            pet.setType(type);
            pet.setOwner(owner);
            pet.setVisits(visits);
            return pet;
        }
    }

