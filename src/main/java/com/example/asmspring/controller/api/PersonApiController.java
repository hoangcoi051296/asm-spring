package com.example.asmspring.controller.api;

import com.example.asmspring.dto.person.PersonDTO;
import com.example.asmspring.dto.person.PersonRequest;
import com.example.asmspring.dto.person.PersonResponse;
import com.example.asmspring.entity.PersonEntity;
import com.example.asmspring.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PersonApiController {
    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    public ResponseEntity<?> index(@Validated @ModelAttribute PersonRequest productRequest, Errors error) {
        PersonResponse obj = new PersonResponse();
        if (error.hasErrors()) {
            String msg =
                    error.getAllErrors()
                            .stream()
                            .map(x -> x.getDefaultMessage()).
                            collect(Collectors.joining(","));
            obj.setMsg(msg);
            return ResponseEntity.badRequest().body(obj);
        }
        List<PersonEntity> persons = personService.findAllBySearch(productRequest.getSearch(),productRequest.getGender());
        obj.setMsg("Success");
        obj.setResult(persons);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<PersonEntity> show(@PathVariable("id") Long id) {
        Optional<PersonEntity> person = personService.findById(id);
        System.out.print(person);
        if (person.isPresent()) {
            return new ResponseEntity<>(person.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/persons")
    public ResponseEntity<PersonEntity> store(@RequestBody PersonDTO personDTO) {
        try {
            PersonEntity person = new PersonEntity();

            person.setFirstName(personDTO.getFirstName());
            person.setLastName(personDTO.getLastName());
            person.setLastNameBirth(personDTO.getLastNameBirth());
            person.setBirth(personDTO.getBirth());
            person.setGender(personDTO.getGender());
            person.setDeath(personDTO.getDeath());
            person.setComment(personDTO.getComment());

            personService.save(person);

            return new ResponseEntity<>(person, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<PersonEntity> update(@PathVariable("id") long id, @RequestBody PersonDTO personDTO) {
        Optional<PersonEntity> personEntity = personService.findById(id);

        if (personEntity.isPresent()) {
            PersonEntity person = personEntity.get();

            person.setFirstName(personDTO.getFirstName());
            person.setLastName(personDTO.getLastName());
            person.setLastNameBirth(personDTO.getLastNameBirth());
            person.setBirth(personDTO.getBirth());
            person.setGender(personDTO.getGender());
            person.setDeath(personDTO.getDeath());
            person.setComment(personDTO.getComment());

            personService.save(person);

            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        try {
            personService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
