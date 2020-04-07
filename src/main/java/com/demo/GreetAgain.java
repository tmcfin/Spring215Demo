package com.demo;

import org.springframework.stereotype.Component;

@Component
public class GreetAgain implements GreetInterface {

    @Override
    public String greet() {
        return "Hello Again!";
    }
}
