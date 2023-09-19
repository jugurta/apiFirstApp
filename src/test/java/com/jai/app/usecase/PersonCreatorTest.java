package com.jai.app.usecase;

import com.jai.app.domain.model.Person;
import com.jai.app.domain.repository.PersonRepository;
import com.jai.app.providers.PersonProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PersonCreatorTest {


    PersonCreator personCreator;
    PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        personRepository = mock(PersonRepository.class);
        personCreator = new PersonCreator(personRepository);
    }


    @ParameterizedTest
    @ArgumentsSource(PersonProvider.class)
    void givenPersonToSaveShouldReturnPersonModel(Person person) {
        //GIVEN
        when(personRepository.save(any(Person.class))).thenAnswer(invocationOnMock -> Mono.just(person));
        //WHEN
        Mono<Person> result = personCreator.createPerson(person);
        //THEN
        StepVerifier
                .create(result)
                .expectNext(person)
                .verifyComplete();
        verify(personRepository, times(1)).save(person);
    }
}
