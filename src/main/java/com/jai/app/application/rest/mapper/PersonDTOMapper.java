package com.jai.app.application.rest.mapper;

import com.jai.app.application.rest.dto.PersonDTO;
import com.jai.app.domain.model.Person;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PersonDTOMapper {
    Person toDomain(PersonDTO personDTO);
    PersonDTO toDTO(Person person);
}
