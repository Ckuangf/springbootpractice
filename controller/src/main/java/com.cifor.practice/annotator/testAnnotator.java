package com.cifor.practice.annotator;


import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface testAnnotator {

    @testAnnotator("monicker")
    String value() default "";

    @testAnnotator("value")
    String monicker() default "";

}
