package com.meteor.auth.subscriber;

import com.meteor.libs.subscriber.DomainEventSubscriber;
import com.meteor.libs.subscriber.IEventHandler;

@DomainEventSubscriber(name="IdentityAddedEvent")
public class AddIdentityEventSubscriber  implements IEventHandler {
    @Override
    public void handle(String payload) {
        System.out.println("here in subscriber " + payload);
        return;
    }
}
