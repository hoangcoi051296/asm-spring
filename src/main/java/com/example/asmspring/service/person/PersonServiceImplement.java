package com.example.asmspring.service.person;

import com.example.asmspring.entity.PersonEntity;
import com.example.asmspring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImplement implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public List<PersonEntity> getAll()  {
        return (List<PersonEntity>) personRepository.findAll();
    }

    @Override
    public List<PersonEntity> findByLastNameContaining(String name) {
        if (name.equals("")){
            return (List<PersonEntity>) personRepository.findAll();
        }
        return personRepository.findByLastNameContaining(name);
    }

    @Override
    public List<PersonEntity> findAllBySearch(String search,String gender) {
        return personRepository.findAllBySearch(search,gender);
    }

    @Override
    public void save(PersonEntity person) {
        personRepository.save(person);
    }

    //    @Override
//    public PersonEntity findById(Long id) {
//        Optional<PersonEntity> person = personRepository.findById(id);
//        return person.get();
//    }
    @Override
    public Optional<PersonEntity> findById(Long id) {

        return personRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
