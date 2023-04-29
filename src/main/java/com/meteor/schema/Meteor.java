package com.meteor.schema;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "meteor")
public class Meteor {
        @Id
        private String id;

        private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    Meteor(String name){
        this.name = name;
    }
}
