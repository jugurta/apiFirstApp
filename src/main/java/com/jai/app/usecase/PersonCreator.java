package com.jai.app.usecase;


import com.jai.app.domain.model.Person;
import com.jai.app.domain.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class PersonCreator {
    private final PersonRepository personRepository;
    public Mono<Person> createPerson(Person person) {
        return personRepository.save(person);
    }
}
