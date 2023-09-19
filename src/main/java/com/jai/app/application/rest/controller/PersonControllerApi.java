package com.jai.app.application.rest.controller;

import com.jai.app.application.rest.dto.PersonDTO;
import com.jai.app.application.rest.mapper.PersonDTOMapper;
import com.jai.app.usecase.PersonCreator;
import com.jai.app.usecase.PersonFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class PersonControllerApi implements PersonApi {

    private final PersonDTOMapper personDTOMapper;
    private final PersonCreator personCreator;
    private final PersonFetcher personFetcher;

    @Override
    public Mono<PersonDTO> createPerson(Mono<PersonDTO> personDTOMono, ServerWebExchange exchange) {
        return personDTOMono
                .map(personDTOMapper::toDomain)
                .flatMap(personCreator::createPerson)
                .map(personDTOMapper::toDTO);
    }

    @Override
    public Mono<PersonDTO> getPerson(Integer id, ServerWebExchange exchange) {
        return personFetcher.findById(Long.valueOf(id)).map(personDTOMapper::toDTO);
    }

}
