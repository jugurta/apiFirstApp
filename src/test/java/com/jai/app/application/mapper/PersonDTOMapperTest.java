package com.jai.app.application.mapper;

import com.jai.app.application.rest.dto.PersonDTO;
import com.jai.app.application.rest.mapper.PersonDTOMapper;
import com.jai.app.application.rest.mapper.PersonDTOMapperImpl;
import com.jai.app.domain.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class PersonDTOMapperTest {

    PersonDTOMapper personDTOMapper;

    @BeforeEach
    void setUp() {
        personDTOMapper = new PersonDTOMapperImpl();
    }

    @ParameterizedTest
    @MethodSource("com.jai.app.providers.PersonProviders#provideModelAndDTO")
    void givenPersonDTOShouldMapPersonModel(Person person, PersonDTO personDTO) {
        Assertions.assertEquals(personDTOMapper.toDomain(personDTO), person);
    }

    @ParameterizedTest
    @MethodSource("com.jai.app.providers.PersonProviders#provideModelAndDTO")
    void givenPersonModelShouldMapPersonDTO(Person person, PersonDTO personDTO) {
        Assertions.assertEquals(personDTOMapper.toDTO(person), personDTO);
    }
}
