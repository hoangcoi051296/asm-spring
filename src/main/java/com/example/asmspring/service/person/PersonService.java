package com.example.asmspring.service.person;

import com.example.asmspring.entity.PersonEntity;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    public List<PersonEntity> getAll();

    public void save(PersonEntity person);

    //    public PersonEntity findById(Long id);

    public Optional<PersonEntity> findById(Long id);
    public void deleteById(Long id);

    public List<PersonEntity> findByLastNameContaining(String name);


    public List<PersonEntity> findAllBySearch(String search,String gender);
}
