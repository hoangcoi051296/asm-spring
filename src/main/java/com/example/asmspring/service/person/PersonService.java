package com.example.asmspring.service.person;

import com.example.asmspring.entity.PersonEntity;

import java.util.List;

public interface PersonService {
    public List<PersonEntity> getAll();
    public PersonEntity findById(Long id);

}
