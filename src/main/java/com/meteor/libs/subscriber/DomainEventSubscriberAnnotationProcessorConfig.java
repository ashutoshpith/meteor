package com.meteor.libs.subscriber;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.processing.Processor;

@Configuration
@ConditionalOnClass(Processor.class)
public class DomainEventSubscriberAnnotationProcessorConfig {
    @Bean
    public DomainEventSubscriberAnotationProcessor myAnnotationProcessor() {
        System.out.println("here sfsf sd");
        return new DomainEventSubscriberAnotationProcessor();
    }
}
