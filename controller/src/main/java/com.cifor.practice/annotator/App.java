package com.cifor.practice.annotator;

import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class App {


    public static void main(String[] args){

        try {
            Class<?> aClass = Class.forName("com.cifor.practice.annotator.Entity");
            Method a = aClass.getMethod("a");
            Method b = aClass.getMethod("b");
//            Method c = aClass.getMethod("c");
            testAnnotator annotation1 = a.getAnnotation(testAnnotator.class);
            System.out.println(annotation1.value());
            System.out.println(annotation1.monicker());
            System.out.println("===========================");

            AliasFor alis = b.getAnnotation(AliasFor.class);
            System.out.println(alis.value());
            System.out.println(alis.attribute());
            System.out.println("===========================");

            ContextConfiguration cc = AnnotationUtils.findAnnotation(Entity.class,
                    ContextConfiguration.class);
            System.out.println(cc.locations());
            System.out.println(cc.value());
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxx");
            ContextConfiguration annotation = aClass.getAnnotation(ContextConfiguration.class);
            System.out.println(annotation.value());
            System.out.println(annotation.locations());

           /* ContextConfiguration cc = AnnotationUtils.findAnnotation(Entity.class,
                    ContextConfiguration.class);
            System.out.println(
                    StringUtils.arrayToCommaDelimitedString(cc.locations()));
            System.out.println(StringUtils.arrayToCommaDelimitedString(cc.value()));*/


            /*MyAnnotator ca = c.getAnnotation(MyAnnotator.class);
            System.out.println(ca.value());
            System.out.println(ca.monicker());
            System.out.println("===========================");*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}
