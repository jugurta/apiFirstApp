package com.jai.app.application.controller;

import com.jai.app.application.rest.controller.PersonControllerApi;
import com.jai.app.application.rest.dto.PersonDTO;
import com.jai.app.application.rest.mapper.PersonDTOMapper;
import com.jai.app.application.rest.mapper.PersonDTOMapperImpl;
import com.jai.app.domain.model.Person;
import com.jai.app.providers.PersonDTOProvider;
import com.jai.app.usecase.PersonCreator;
import com.jai.app.usecase.PersonFetcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PersonControllerApiTest {

    PersonDTOMapper personDTOMapper;
    PersonCreator personCreator;
    PersonFetcher personFetcher;
    PersonControllerApi personControllerApi;

    @BeforeEach
    void setUp() {
        personDTOMapper = new PersonDTOMapperImpl();
        personCreator = mock(PersonCreator.class);
        personFetcher = mock(PersonFetcher.class);
        personControllerApi = new PersonControllerApi(personDTOMapper, personCreator, personFetcher);
    }


    @ParameterizedTest
    @ArgumentsSource(PersonDTOProvider.class)
    void givenPersonDTOShouldCreatePerson(PersonDTO personDTO) {
        //GIVE
        when(personCreator.createPerson(any(Person.class))).thenAnswer(invocationOnMock -> Mono.just(invocationOnMock.getArguments()[0]));
        //WHEN
        Mono<PersonDTO> result = personControllerApi.createPerson(Mono.just(personDTO), null);
        //THEN
        StepVerifier
                .create(result)
                .expectNext(personDTO)
                .verifyComplete();
        verify(personCreator, times(1)).createPerson(any(Person.class));
    }

    @ParameterizedTest
    @MethodSource("com.jai.app.providers.PersonProviders#provideModelAndDTO")
    void whenFindByIdShouldReturnPersonDTO(Person person, PersonDTO personDTO) {
        //GIVEN
        when(personFetcher.findById(anyLong())).thenAnswer(invocationOnMock -> Mono.just(person));
        //WHEN
        Mono<PersonDTO> result = personControllerApi.getPerson(1, null);
        //THEN
        StepVerifier.create(result)
                .expectNext(personDTO)
                .verifyComplete();
    }
}
