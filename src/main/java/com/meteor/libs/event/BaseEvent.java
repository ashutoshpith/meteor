package com.meteor.libs.event;

public class BaseEvent {
    private String id;
    private String name;
    BaseEvent(
             String id,
             String name
    ){
        this.id = id;
        this.name = name;
    }
}
