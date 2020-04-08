package com.demo;

//import org.springframework.stereotype.Component;
//
//@Component
//public class FriendlyGreeter implements GreetInterface {
public class FriendlyGreeter extends GreeterBase {
    @Override
    public String greet() {
        greetCount++;
        return "Friendly Greeting " + greetCount;
    }
}
