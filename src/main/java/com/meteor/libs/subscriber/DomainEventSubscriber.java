package com.meteor.libs.subscriber;

import com.google.auto.service.AutoService;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Processor;
import java.lang.annotation.*;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DomainEventSubscriber {
    String name();

    String value() default "";
}
