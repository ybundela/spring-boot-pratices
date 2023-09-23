package com.restServices.apisDemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoRestContriller {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello Yogi";
    }
}
