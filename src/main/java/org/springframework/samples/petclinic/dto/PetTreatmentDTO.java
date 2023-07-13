package org.springframework.samples.petclinic.dto;

/* Data transfer object class for PetTreatment with fields as below
 * id: int
 * petId: int
 * petName: String
 * vet: Vet 
 * treatmentDate: LocalDate
 * description: String
 * speciality: Specialty
*/
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.Specialty;

public class    PetTreatmentDTO {
    private int id;
    private int petId;
    private String petName;
    private int vetId;
    private String vetName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate treatmentDate;
    private String description;
    private int specialityId;
    private Specialty speciality;
    // sepciatlyId gettet and setter

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    //petId
    public int getPetId() {
        return petId;
    }
    public void setPetId(int petId) {
        this.petId = petId;
    }
    
    //petName
    public String getPetName() {
        return petName;
    }
    public void setPetName(String petName) {
        this.petName = petName;
    }
    
    //vetId
    public int getVetId() {
        return vetId;
    }
    public void setVetId(int vetId) {
        this.vetId = vetId;
    }
    
    //vetName
    public String getVetName() {
        return vetName;
    }
    public void setVetName(String vetName) {
        this.vetName = vetName;
    }
    
    //treatmentDate
    public LocalDate getTreatmentDate() {
        return treatmentDate;
    }
    public void setTreatmentDate(LocalDate treatmentDate) {
        this.treatmentDate = treatmentDate;
    }
    
    //description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    //speciality
    public Specialty getSpeciality() {
        return speciality;
    }
    public void setSpeciality(Specialty speciality) {
        this.speciality = speciality;
    }

    //tosting
    @Override
    public String toString() {
        return "PetTreatmentDTO [description=" + description + ", id=" + id + ", petId=" + petId + ", petName="
                + petName + ", speciality=" + speciality + ", treatmentDate=" + treatmentDate + ", vetId=" + vetId
                + ", vetName=" + vetName + "]";
    }

    //constructor with fields
    public PetTreatmentDTO(int id, int petId, String petName, int vetId, String vetName, LocalDate treatmentDate,
            String description, Specialty speciality) {
        this.id = id;
        this.petId = petId;
        this.petName = petName;
        this.vetId = vetId;
        this.vetName = vetName;
        this.treatmentDate = treatmentDate;
        this.description = description;
        this.speciality = speciality;
    }

    //constructor without fields
    public PetTreatmentDTO() {
    }

}

