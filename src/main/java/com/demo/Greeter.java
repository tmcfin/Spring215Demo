package com.demo;

//import org.springframework.stereotype.Component;
//
//@Component(value = "greeter1")
//public class Greeter implements GreetInterface {
public class Greeter extends GreeterBase {
    @Override
    public String greet() {
        greetCount++;
        return "Hello " + greetCount;
    }
}
