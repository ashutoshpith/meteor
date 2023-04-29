package com.meteor.libs.guard;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthGuard {

    String name() default "Private";

    String value() default "Haka";

}
