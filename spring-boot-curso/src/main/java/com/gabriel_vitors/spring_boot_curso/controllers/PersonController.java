package com.gabriel_vitors.spring_boot_curso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel_vitors.spring_boot_curso.data.dto.PersonDTO;
import com.gabriel_vitors.spring_boot_curso.model.Person;
import com.gabriel_vitors.spring_boot_curso.services.PersonServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;


    @GetMapping("/{id}")    
    public PersonDTO findById(@PathVariable("id") Long id){

        return service.findById(id);
    }

    @GetMapping()    
    public List<PersonDTO> findAll(){

        return service.findAll();
    }

    @PostMapping()
    public PersonDTO create(@RequestBody PersonDTO person) {
        
        return service.create(person);
    }

    @PutMapping("")
    public PersonDTO update(@RequestBody PersonDTO person) {
        
        return service.update(person);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
 