package com.meteor.libs.subscriber;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class DomainEventSubscriberAnotation {
    @Pointcut("@annotation(DomainEventSubscriber)")
    public void loggedDataSubscriber() {
        System.out.println("Are you subscriber");
    }

    @Before(value = "loggedDataSubscriber()")
    public void before(JoinPoint joinPoint) {
        System.out.println("Join Point Before subscriber " + joinPoint.getSignature() );
    }

}
