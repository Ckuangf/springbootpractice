package com.cifor.practice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/temp")
public class TempController {

    @GetMapping
    public String getSomeThing(@RequestParam String id){
        return "get temp";
    }

/*    @GetMapping
    public String getSomeThing2(@RequestParam String id){
        return "get temp2";
    }*/

}
