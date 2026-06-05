package com.gabriel_vitors.spring_boot_curso.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gabriel_vitors.spring_boot_curso.data.dto.PersonDTO;
import com.gabriel_vitors.spring_boot_curso.data.dto.v2.PersonDTOV2;
import com.gabriel_vitors.spring_boot_curso.model.Person;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO personToPersonDTO(Person person);

    Person personDTOTOPerson(PersonDTO personDTO);

    List<PersonDTO> personToPersonDTOList(List<Person> persons);


    Person personDTOV2TOPerson(PersonDTOV2 personDTOV2);

    PersonDTOV2 personToPersonDTOV2(Person person);
}
