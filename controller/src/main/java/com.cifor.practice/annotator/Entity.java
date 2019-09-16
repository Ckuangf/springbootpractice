package com.cifor.practice.annotator;


import org.springframework.core.annotation.AliasFor;

@ContextConfiguration("aa.xml")
public class Entity {

    @testAnnotator("aaa")
    public void a(){

    }

    @AliasFor( value = "bbb", attribute = "mmm")
    public void b(){

    }

    /*
    @MyAnnotator(value = "ccc")
    public void c(){

    }*/


}
