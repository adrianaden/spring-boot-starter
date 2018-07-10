package com.adrianaden.springboot.starter.repository;

import com.adrianaden.springboot.starter.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
