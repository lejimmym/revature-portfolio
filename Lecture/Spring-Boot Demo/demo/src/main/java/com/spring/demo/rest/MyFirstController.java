package com.spring.demo.rest;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
//Terminal cd demo
//mvn spring-boot:run

@RestController
public class MyFirstController {

    private static final Logger logger = LoggerFactory.getLogger(MyFirstController.class);

     @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }
    @GetMapping("/test")
    public String hotReload() {
        return "Hot Reload";
    }
    
}