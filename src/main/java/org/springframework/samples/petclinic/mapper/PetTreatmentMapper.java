package org.springframework.samples.petclinic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.samples.petclinic.dto.PetTreatmentDTO;
import org.springframework.samples.petclinic.model.PetTreatment;

import java.util.List;


/* interface pettreatment mapper for mapping fields of PetTreatment to PetTreatmentDTO*/ 

@Mapper
    public interface PetTreatmentMapper {
        PetTreatmentMapper INSTANCE = Mappers.getMapper(PetTreatmentMapper.class);

        @Mapping(source = "pet.id", target = "petId")
        @Mapping(source = "vet.id", target = "vetId")
        @Mapping(source = "pet.name", target = "petName")
        @Mapping(source = "vet.firstName", target = "vetName")
        @Mapping(source = "speciality.id", target = "specialityId")
        PetTreatmentDTO petTreatmentToPetTreatmentDTO(PetTreatment petTreatment);

        List<PetTreatmentDTO> petTreatmentsToPetTreatmentDTOs(List<PetTreatment> petTreatments);

        @Mapping(source = "petId", target = "pet.id")
        @Mapping(source = "vetId", target = "vet.id")
        @Mapping(source = "petName", target = "pet.name")
        @Mapping(source = "vetName", target = "vet.firstName")
        PetTreatment petTreatmentDTOToPetTreatment(PetTreatmentDTO petTreatmentDTO);

        List<PetTreatment> petTreatmentDTOsToPetTreatments(List<PetTreatmentDTO> petTreatmentDTOs);
    }