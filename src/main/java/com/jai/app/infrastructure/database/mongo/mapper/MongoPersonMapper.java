package com.jai.app.infrastructure.database.mongo.mapper;

import com.jai.app.domain.model.Person;
import com.jai.app.infrastructure.database.mongo.entity.PersonEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MongoPersonMapper {

    Person toDomain(PersonEntity personEntity);
    PersonEntity toEntity(Person person);
}
