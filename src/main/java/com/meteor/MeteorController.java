package com.meteor;

import com.meteor.libs.guard.AuthGuard;
import com.meteor.libs.messageBroker.rmq.RabbitMQProducer;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/meteor")
@RestController
public class MeteorController {
    private RabbitMQProducer producer;

    public MeteorController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    @AuthGuard(name = "Public")
    @GetMapping("/health")
    public String health(@RequestHeader HttpHeaders res) {

        System.out.println("Here in fine");
        return "I'm fine";
    }

//    @AuthGuard
    @GetMapping
    public String home(@RequestHeader HttpHeaders res) {
        producer.sendMessage("IdentityAddedEvent");
        return "I'm Home !!!";
    }
}
