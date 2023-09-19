package com.jai.app.usecase;

import com.jai.app.domain.model.Person;
import com.jai.app.domain.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class PersonFetcher {

    private final PersonRepository personRepository;
    public Mono<Person> findById(Long id) {
        return personRepository.findById(id);
    }

}
