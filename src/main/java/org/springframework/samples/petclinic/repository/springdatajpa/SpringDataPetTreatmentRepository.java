package org.springframework.samples.petclinic.repository.springdatajpa;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.model.PetTreatment;

@Profile("spring-data-jpa")
public interface SpringDataPetTreatmentRepository extends JpaRepository<PetTreatment, Integer> {
    
        @Query("SELECT DISTINCT petTreatment FROM PetTreatment petTreatment left join fetch petTreatment.pet left join fetch petTreatment.vet left join fetch petTreatment.speciality WHERE petTreatment.id =:id")
        PetTreatment findById(int id);
    
        @Query("SELECT DISTINCT petTreatment FROM PetTreatment petTreatment left join fetch petTreatment.pet left join fetch petTreatment.vet left join fetch petTreatment.speciality")
        List<PetTreatment> findAll();
    
        @Query("SELECT DISTINCT petTreatment FROM PetTreatment petTreatment left join fetch petTreatment.pet left join fetch petTreatment.vet left join fetch petTreatment.speciality WHERE petTreatment.pet.id =:petId")
        List<PetTreatment> findByPetId(int petId);
    
        @Query("SELECT DISTINCT petTreatment FROM PetTreatment petTreatment left join fetch petTreatment.pet left join fetch petTreatment.vet left join fetch petTreatment.speciality WHERE petTreatment.vet.id =:vetId")
        List<PetTreatment> findByVetId(int vetId);
    
        @Query("SELECT DISTINCT petTreatment FROM PetTreatment petTreatment left join fetch petTreatment.pet left join fetch petTreatment.vet left join fetch petTreatment.speciality WHERE petTreatment.pet.name LIKE 'S%'")
        List<PetTreatment> findByPetNameStartsWithS();

        void delete(PetTreatment petTreatment);

        // jpa query for find by pettreatment id
        PetTreatment findPetTreatmentById(int petTreatmentId);

    }