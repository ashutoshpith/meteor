package com.meteor.repo;

import com.meteor.schema.Meteor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MeteorRepo extends MongoRepository<Meteor, String> {
    public Meteor findByName(String name);
}
