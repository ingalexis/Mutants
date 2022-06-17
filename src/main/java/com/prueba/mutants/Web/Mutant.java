package com.prueba.mutants.Web;

import com.prueba.mutants.UseCase.ValidateMutant;
import com.prueba.mutants.Web.Wrapper.MutantWrapper;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class Mutant {

    @PostMapping(value = "/mutants", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void mutants(@RequestBody MutantWrapper mutant) {
        ValidateMutant validateMutant = new ValidateMutant(mutant.getDna().toArray(new String[0]));
        if(!validateMutant.validateMutant()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        } else {
            throw new ResponseStatusException(HttpStatus.OK);
        }
    }
}
