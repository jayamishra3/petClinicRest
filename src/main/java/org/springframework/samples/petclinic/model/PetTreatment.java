package org.springframework.samples.petclinic.model;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JacksonInject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



/* PetClinic modal class with fields as below
 * id: int
 * pet: Pet
 * vet: Vet
 * date: Date
 * description: String
 * speciality: Specialty
 * 
 * create mappings to table pet_treatments using JPA annotations
 */
@Entity
@Table(name = "pet_treatment")
public class PetTreatment extends BaseEntity {
    
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
    
    @ManyToOne
    @JoinColumn(name = "vet_id")
    private Vet vet;
    
    @Column(name = "treatment_date")
    private LocalDate treatmentDate;
    
    @Column(name = "description")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty speciality;
    
    public Pet getPet() {
        return pet;
    }
    public void setPet(Pet pet) {
        this.pet = pet;
    }
    public Vet getVet() {
        return vet;
    }
    public void setVet(Vet vet) {
        this.vet = vet;
    }
    public LocalDate getTreatmentDate() {
        return treatmentDate;
    }
    public void setTreatmentDate(LocalDate treatmentDate) {
        this.treatmentDate = treatmentDate;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Specialty getSpeciality() {
        return speciality;
    }
    public void setSpeciality(Specialty speciality) {
        this.speciality = speciality;
    }
    
   @Override
   public String toString() {
       return "PetTreatment [pet=" + pet + ", vet=" + vet + ", treatmentDate=" + treatmentDate + ", description="
               + description + ", speciality=" + speciality + "]";
   } 
    
}
