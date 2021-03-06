package com.playground.playground.springboot.webservices.restful.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    // GET
    // URI - /hello-world
    // method - "Hello world"
    @GetMapping(path = "/hello-world")
    public String helloWorld () {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean () {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world-variable/{name}")
    public HelloWorldBean helloWorldPathVariable (@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
