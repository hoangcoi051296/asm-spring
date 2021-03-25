package com.example.asmspring.repository;

import com.example.asmspring.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    @Override
    List<PersonEntity> findAll();
}
