package com.jai.app.infrastructure.database.mongo.adapter;

import com.jai.app.domain.model.Person;
import com.jai.app.domain.repository.PersonRepository;
import com.jai.app.infrastructure.database.mongo.mapper.MongoPersonMapper;
import com.jai.app.infrastructure.database.mongo.repository.ReactiveMongoPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class PersonRepositoryAdapter implements PersonRepository {
    private final ReactiveMongoPersonRepository reactiveMongoPersonRepository;
    private final MongoPersonMapper mongoPersonMapper;
    @Override
    public Mono<Person> save(Person person) {
        return reactiveMongoPersonRepository.save(mongoPersonMapper.toEntity(person)).map(mongoPersonMapper::toDomain);
    }
    @Override
    public Mono<Person> findById(Long id) {
        return reactiveMongoPersonRepository.findById(id).map(mongoPersonMapper::toDomain);
    }
}
