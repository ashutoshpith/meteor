package com.meteor.libs.subscriber;

import com.google.auto.service.AutoService;
import com.meteor.libs.messageBroker.rmq.RabbitMQConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import javax.annotation.processing.Processor;


@AutoService(Processor.class)
@Service
public class Subscriber {
    public Subscriber(){
        System.out.println("here subscriber sfs");
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message) {
        LOGGER.info(String.format("Received message here -> %s", message));
        IEventHandler handler =  DomainEventMap.get(message);
        System.out.println(DomainEventMap.class);
        System.out.println(handler);
//        handler.handle(message);
    }

}
