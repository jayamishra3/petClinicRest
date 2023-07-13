/* PetTreatmentNotFoundException class */
package org.springframework.samples.petclinic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Pet Treatment Not Found")
public class PetTreatmentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PetTreatmentNotFoundException() {
        super("Pet Treatment Not Found");
    }

    public PetTreatmentNotFoundException(String message) {
        super(message);
    }
    
}
