package com.gabriel_vitors.spring_boot_curso.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel_vitors.spring_boot_curso.controllers.TesteLogController;
import com.gabriel_vitors.spring_boot_curso.data.dto.PersonDTO;
import com.gabriel_vitors.spring_boot_curso.exception.ResourceNotFoundException;
import com.gabriel_vitors.spring_boot_curso.mapper.PersonMapper;
import com.gabriel_vitors.spring_boot_curso.model.Person;
import com.gabriel_vitors.spring_boot_curso.repository.PersonRepository;


@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PersonRepository repository;

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    public PersonDTO findById(Long id){
        logger.info("Finding one Person!");

        var person = repository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No recors found for this ID")
        );

        return PersonMapper.INSTANCE.personToPersonDTO(person);
    }

    public List<PersonDTO> findAll(){
        logger.info("Finding all Peaplo!");

        return PersonMapper.INSTANCE.personToPersonDTOList(repository.findAll());

    }

    public PersonDTO create(PersonDTO personDTO){
        logger.info("Creating one Person!");

        var person = PersonMapper.INSTANCE.personDTOTOPerson(personDTO);

        return PersonMapper.INSTANCE.personToPersonDTO(repository.save(person));
    }

    public PersonDTO update(PersonDTO personDTO){
        logger.info("Updating one Person!");

        var entity = this.findById(personDTO.getId());

        entity.setFirstName(personDTO.getFirstName());
        entity.setLastName(personDTO.getLastName());
        entity.setGender(personDTO.getGender());
        entity.setAddress(personDTO.getAddress());

        var person = PersonMapper.INSTANCE.personDTOTOPerson(personDTO);

        return PersonMapper.INSTANCE.personToPersonDTO(repository.save(person));
    }

    public void delete(Long id){
        logger.info("Updating one Person!");

        var entity = PersonMapper.INSTANCE.personDTOTOPerson(this.findById(id));

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
