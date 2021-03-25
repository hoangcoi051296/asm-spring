package com.example.asmspring.controller.api;

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
        List<PersonEntity> persons = personService.getAll();
        obj.setMsg("Success");
        obj.setResult(persons);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<PersonEntity> show(@PathVariable("id") Long id) {
        PersonEntity person = personService.findById(id);
            System.out.print(person);
//        if () {
            return new ResponseEntity<>(person, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
    }
}
