package com.gabriel_vitors.spring_boot_curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel_vitors.spring_boot_curso.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
