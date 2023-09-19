package com.jai.app.infrastructure.database.mongo.adapter;

import com.jai.app.domain.model.Person;
import com.jai.app.infrastructure.database.mongo.entity.PersonEntity;
import com.jai.app.infrastructure.database.mongo.mapper.MongoPersonMapper;
import com.jai.app.infrastructure.database.mongo.mapper.MongoPersonMapperImpl;
import com.jai.app.infrastructure.database.mongo.repository.ReactiveMongoPersonRepository;
import com.jai.app.providers.PersonProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PersonRepositoryAdapterTest {

    ReactiveMongoPersonRepository reactiveMongoPersonRepository;
    MongoPersonMapper mongoPersonMapper;
    PersonRepositoryAdapter personRepositoryAdapter;

    @BeforeEach
    void setUp() {
        mongoPersonMapper = new MongoPersonMapperImpl();
        reactiveMongoPersonRepository = mock(ReactiveMongoPersonRepository.class);
        personRepositoryAdapter = new PersonRepositoryAdapter(reactiveMongoPersonRepository, mongoPersonMapper);
    }


    @ParameterizedTest
    @ArgumentsSource(PersonProvider.class)
    void givenPersonModelShouldSaveAndReturnPersonModel(Person person) {
        //GIVEN
        when(reactiveMongoPersonRepository.save(any(PersonEntity.class))).thenAnswer(invocationOnMock -> Mono.just(invocationOnMock.getArguments()[0]));
        //WHEN
        Mono<Person> result = personRepositoryAdapter.save(person);
        //THEN
        StepVerifier
                .create(result)
                .expectNext(person)
                .verifyComplete();
    }

    @ParameterizedTest
    @MethodSource("com.jai.app.providers.PersonProviders#provideModelAndEntity")
    void givenIdentifierShouldReturnPersonModel(Person person, PersonEntity personEntity) {
        //GIVEN
        when(reactiveMongoPersonRepository.findById(anyLong())).thenAnswer(invocationOnMock -> Mono.just(personEntity));
        //WHEN
        Mono<Person> result = personRepositoryAdapter.findById(1L);
        //THEN
        StepVerifier
                .create(result)
                .expectNext(person)
                .verifyComplete();
    }

    @ParameterizedTest
    @MethodSource("com.jai.app.providers.PersonProviders#provideModelAndEntity")
    void givenFindByIdRequestShouldReturnAllPersonModel(Person person, PersonEntity personEntity) {
        //GIVEN
        when(reactiveMongoPersonRepository.findById(anyLong())).thenAnswer(invocationOnMock -> Mono.just(personEntity));
        //WHEN
        Mono<Person> result = personRepositoryAdapter.findById(anyLong());
        //THEN
        StepVerifier
                .create(result)
                .expectNext(person)
                .verifyComplete();
    }
}
