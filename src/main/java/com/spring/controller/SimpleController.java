package com.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.CompletableFuture;

//@Controller
@RestController
public class SimpleController {

    @Value("${some.value}")
    private String someValue;

    @RequestMapping("/hello")
//    @ResponseBody
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("name", "Bhushan");
        return modelAndView;
    }

    @RequestMapping("/body")
    public String body(){
        System.out.println(someValue);
        return "some data..."+someValue;
    }



}
