package com.meteor.libs.guard;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Slf4j
@Component
public class AuthGuardAnnotation {

    @Around("@annotation(AuthGuard)")
    public Object trace(ProceedingJoinPoint joinPoint)  throws Throwable {
        System.out.println("Here we are in1");
        System.out.println("Input :\n" + joinPoint.getArgs()[0] + "\n");
        System.out.println("here "+ joinPoint.getSignature());
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        AuthGuard method = signature.getMethod().getAnnotation(AuthGuard.class);
        System.out.println("you know me " +method.name() + "-" + method.value());
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // Read the value of the specified header
        String headerValue = request.getHeader("Authorization");
        System.out.println("auth :- " + headerValue);
        Object result = joinPoint.proceed();
        System.out.println("Here we are out2");

        return result;
    }

    @Pointcut("@annotation(AuthGuard)")
    public void loggedData() {
        System.out.println("Are you there");
    }

    @Before(value = "loggedData()")
    public void before(JoinPoint joinPoint) {
        System.out.println("Join Point Before" + joinPoint.getSignature() );
    }

    @After(value = "loggedData()")
    public void after(JoinPoint joinPoint) {
        System.out.println("Join Point After" + joinPoint.getSignature());
    }
}
