package com.jai.app.usecase;

import com.jai.app.domain.model.Person;
import com.jai.app.domain.repository.PersonRepository;
import com.jai.app.providers.PersonProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

class PersonFetcherTest {
    PersonFetcher personFetcher;
    PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        personRepository = mock(PersonRepository.class);
        personFetcher = new PersonFetcher(personRepository);
    }

    @ParameterizedTest
    @ArgumentsSource(PersonProvider.class)
    void givenFetchAllShouldReturnPersons(Person person) {
        //GIVEN
        when(personRepository.findById(anyLong())).thenAnswer(invocationOnMock -> Mono.just(person));
        //WHEN
        Mono<Person> result = personFetcher.findById(anyLong());
        //THEN
        StepVerifier
                .create(result)
                .expectNext(person)
                .verifyComplete();
        verify(personRepository, times(1)).findById(anyLong());
    }

    @ParameterizedTest
    @ArgumentsSource(PersonProvider.class)
    void givenFetchPersonByIdShouldReturnPerson(Person person) {
        //GIVEN
        when(personRepository.findById(anyLong())).thenAnswer(invocationOnMock -> Mono.just(person));
        //WHEN
        Mono<Person> result = personFetcher.findById(anyLong());
        //THEN
        StepVerifier
                .create(result)
                .expectNext(person)
                .verifyComplete();
        verify(personRepository, times(1)).findById(anyLong());
    }
}
