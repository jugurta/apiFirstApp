package com.jai.app.infrastructure.database.mongo.mapper;

import com.jai.app.domain.model.Person;
import com.jai.app.infrastructure.database.mongo.entity.PersonEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class MongoPersonMapperTest {

    MongoPersonMapper mongoPersonMapper;

    @BeforeEach
    void setUp() {
        mongoPersonMapper = new MongoPersonMapperImpl();
    }

    @ParameterizedTest
    @MethodSource("com.jai.app.providers.PersonProviders#provideModelAndEntity")
    void givenPersonEntityShouldMapPersonModel(Person person, PersonEntity personEntity) {
        Assertions.assertEquals(mongoPersonMapper.toEntity(person), personEntity);
    }

    @ParameterizedTest
    @MethodSource("com.jai.app.providers.PersonProviders#provideModelAndEntity")
    void givenPersonModelShouldMapPersonEntity(Person person, PersonEntity personEntity) {
        Assertions.assertEquals(mongoPersonMapper.toDomain(personEntity), person);
    }

}
