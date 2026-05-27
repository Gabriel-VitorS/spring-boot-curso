package com.gabriel_vitors.spring_boot_curso.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel_vitors.spring_boot_curso.exception.ResourceNotFoundException;
import com.gabriel_vitors.spring_boot_curso.model.Person;
import com.gabriel_vitors.spring_boot_curso.repository.PersonRepository;

import java.util.logging.Logger;;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PersonRepository repository;

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(Long id){
        logger.info("Finding one Person!");


        return repository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No recors found for this ID")
        );
    }

    public List<Person> findAll(){
        logger.info("Finding all Peaplo!");

        return repository.findAll();

    }

    public Person create(Person person){
        logger.info("Creating one Person!");

        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating one Person!");

        var entity = this.findById(person.getId());

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());

        return repository.save(person);
    }

    public void delete(Long id){
        logger.info("Updating one Person!");

        var entity = this.findById(id);

        repository.delete(entity);

        return ;
    }


    private Person mockPerson(int i){
        var person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("First name" + i);
        person.setLastName("Last name" + i);
        person.setGender("Masculino");
        person.setAddress("Some adress in Brazil");

        return person;
    }
}
