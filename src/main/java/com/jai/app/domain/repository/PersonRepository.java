package com.jai.app.domain.repository;

import com.jai.app.domain.model.Person;
import reactor.core.publisher.Mono;

public interface PersonRepository {
    Mono<Person> save(Person person);

    Mono<Person> findById(Long id);

}
