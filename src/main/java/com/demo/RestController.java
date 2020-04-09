package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private Greeter greeter;

    @Autowired
    private FriendlyGreeter friendlyGreeter;

    @Autowired
    private GreetInterface greetAgain;

    @Autowired(required = false)
    private NotActuallyABean notABean;

    @RequestMapping("/hello")
    public String hello() {
        return greeter.greet();
    }

    @RequestMapping("/hellofriendly")
    public String helloFriendly() {
        return friendlyGreeter.greet();
    }

    @RequestMapping("/helloagain")
    public String helloAgain() { return greetAgain.greet(); }

}