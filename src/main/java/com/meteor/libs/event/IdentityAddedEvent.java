package com.meteor.libs.event;

public class IdentityAddedEvent extends BaseEvent{

    IdentityAddedEvent(String id, String name) {
        super(id, name);
    }
}
