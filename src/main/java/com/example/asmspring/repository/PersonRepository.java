package com.example.asmspring.repository;

import com.example.asmspring.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    @Override
    List<PersonEntity> findAll();


    public List<PersonEntity> findByLastNameContaining(String name);

    @Query(value = "SELECT e FROM PersonEntity as e WHERE (:search is null or (e.firstName like %:search%)  or (e.lastName like %:search%) or (e.lastNameBirth like %:search%) or  (e.comment like %:search%))" +
             "and (:gender is null or e.gender = :gender)"
    )
    public List<PersonEntity> findAllBySearch(String search , String gender);
}
