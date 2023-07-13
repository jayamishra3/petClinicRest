package org.springframework.samples.petclinic.service;

/* Class implementing PetTreatmentService interface */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.PetTreatment;

import org.springframework.samples.petclinic.repository.springdatajpa.SpringDataPetTreatmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;    
import org.springframework.samples.petclinic.exception.PetTreatmentNotFoundException;
@Service
public class PetTreatmentServiceImpl implements PetTreatmentService {
    
    @Autowired
    private SpringDataPetTreatmentRepository petTreatmentRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<PetTreatment> findAll() {
        //if there is no pet treatments found, throw custom exception petTreatmentNotFoundException
        List<PetTreatment> petTreatments = petTreatmentRepository.findAll();
        if (petTreatments.isEmpty()) {
            throw new PetTreatmentNotFoundException();
        }
        return petTreatments;


       // return petTreatmentRepository.findAll();
    }
    
    
    @Override
    @Transactional(readOnly = true)
    public List<PetTreatment> findByPetId(int petId) {
        return petTreatmentRepository.findByPetId(petId);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<PetTreatment> findByVetId(int vetId) {
        return petTreatmentRepository.findByVetId(vetId);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<PetTreatment> findByPetNameStartsWithS() {
        return petTreatmentRepository.findByPetNameStartsWithS();
    }
   
    @Override
    @Transactional(readOnly = true)
    public PetTreatment findById(int id) {
        return petTreatmentRepository.findById(id);
    }
    
    @Override
    @Transactional
    public void savePetTreatment(PetTreatment petTreatment) {
        petTreatmentRepository.save(petTreatment);
    }
    
    @Override
    @Transactional
    public void deletePetTreatment(PetTreatment petTreatment) {
        petTreatmentRepository.delete(petTreatment);
    }



}
