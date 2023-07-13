package org.springframework.samples.petclinic.service;

/* PetTreatmentService interface with abstract methods for crud operation */

import java.util.List;

import org.springframework.samples.petclinic.model.PetTreatment;

public interface PetTreatmentService {
    
        List<PetTreatment> findAll();
    
        List<PetTreatment> findByPetId(int petId);
    
        List<PetTreatment> findByVetId(int vetId);
    
        List<PetTreatment> findByPetNameStartsWithS();
    
        PetTreatment findById(int id);
    
        void savePetTreatment(PetTreatment petTreatment);
    
        void deletePetTreatment(PetTreatment petTreatment);

    
    }
