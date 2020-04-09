package com.demo;

//public class FriendlyGreeter extends GreeterBase {
//
//    @Override
//    public String greet(){
//        greetCount++;
//        return "Friendly Greeting " + greetCount;
//    }
//}

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class FriendlyGreeter extends GreeterBase implements InitializingBean, DisposableBean {

    @Override
    public String greet() {
        greetCount++;
        return "Friendly Greeting " + greetCount;
        // real-life scenario: set up database connection
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
        // real-life scenario: connect to database
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
        // real-life scenario: close anything (sockets...)
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("postConstruct");
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("preDestroy");
    }
}