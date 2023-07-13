package org.springframework.petclinicUtil;

/* Pet Owner email address validation using regex */
import
java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.samples.petclinic.service.ClinicServiceImpl;

public class OwnerEmailValidation {
    public static boolean validateEmail(Owner owner) {
        //String email = owner.getEmail();
        String email = "uuu@nnn.com";
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }   
}



