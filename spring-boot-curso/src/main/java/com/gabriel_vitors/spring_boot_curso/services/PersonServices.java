package com.gabriel_vitors.spring_boot_curso.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.gabriel_vitors.spring_boot_curso.model.Person;

import java.util.logging.Logger;;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){
        logger.info("Finding one Person!");

        var person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Gabriel");
        person.setLastName("Vitor");
        person.setGender("Masculino");
        person.setAddress("Recife");


        return person;
    }

    public List<Person> findAll(){
        logger.info("Finding all Peaplo!");

        var persons = new ArrayList<Person>();

        for (int i = 0; i < 8; i++) {
            var person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    public Person create(Person person){
        logger.info("Creating one Person!");

        return person;
    }

    public Person update(Person person){
        logger.info("Updating one Person!");

        return person;
    }

    public void delete(String id){
        logger.info("Updating one Person!");

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
