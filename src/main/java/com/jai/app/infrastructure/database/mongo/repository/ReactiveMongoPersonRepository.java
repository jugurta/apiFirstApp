package com.jai.app.infrastructure.database.mongo.repository;

import com.jai.app.infrastructure.database.mongo.entity.PersonEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ReactiveMongoPersonRepository extends ReactiveMongoRepository<PersonEntity, Long> {
}
