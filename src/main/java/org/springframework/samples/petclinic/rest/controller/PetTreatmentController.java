package org.springframework.samples.petclinic.rest.controller;

/* RestController for PetTreatment with a mapping of petTreatments
 * including methods of crud operations
 * inject PetTreatmentService
 * use petTreatmentDTO to transfer data
*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.dto.PetTreatmentDTO;
import org.springframework.samples.petclinic.mapper.PetTreatmentMapper;
import org.springframework.samples.petclinic.model.PetTreatment;
import org.springframework.samples.petclinic.service.PetTreatmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 

@RestController
@RequestMapping("/api/pettreamnets")
public class PetTreatmentController {

    private  PetTreatmentService petTreatmentService;

    private  PetTreatmentMapper petTreatmentMapper;

    @Autowired
    public PetTreatmentController(PetTreatmentService petTreatmentService) {
        this.petTreatmentService = petTreatmentService;
    }

    @Autowired
    public void setPetTreatmentMapper(PetTreatmentMapper petTreatmentMapper) {
        this.petTreatmentMapper = petTreatmentMapper;
    }
    @GetMapping(value = "/{petTreamtmentId}")
    public ResponseEntity<PetTreatmentDTO> getPetTreatment(@PathVariable("petTreamtmentId") int petTreamtmentId) {
        PetTreatment petTreatment = this.petTreatmentService.findById(petTreamtmentId);
        if (petTreatment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(petTreatmentMapper.petTreatmentToPetTreatmentDTO(petTreatment), HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<Collection<PetTreatmentDTO>> getAllPetTreatments() {
        List<PetTreatment> petTreatments = new ArrayList<>(this.petTreatmentService.findAll());
        if (petTreatments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<PetTreatmentDTO> petTreatmentDTOs = petTreatments.stream()
                .map(petTreatmentMapper::petTreatmentToPetTreatmentDTO).collect(Collectors.toList());
        return new ResponseEntity<>(petTreatmentDTOs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addPetTreatment(@RequestBody PetTreatmentDTO petTreatmentDTO) {
        PetTreatment petTreatment = petTreatmentMapper.petTreatmentDTOToPetTreatment(petTreatmentDTO);
        this.petTreatmentService.savePetTreatment(petTreatment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{petTreamtmentId}")
    public ResponseEntity<Void> updatePetTreatment(@RequestBody PetTreatmentDTO petTreatmentDTO,
            @PathVariable("petTreamtmentId") int petTreamtmentId) {
        PetTreatment petTreatment = this.petTreatmentService.findById(petTreamtmentId);
        if (petTreatment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            petTreatment.setDescription(petTreatmentDTO.getDescription());
            petTreatment.setTreatmentDate(petTreatmentDTO.getTreatmentDate());
            this.petTreatmentService.savePetTreatment(petTreatment);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }



  
}
