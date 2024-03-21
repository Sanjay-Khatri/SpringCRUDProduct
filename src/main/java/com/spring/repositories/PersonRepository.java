package com.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.spring.entities.onetomany.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
