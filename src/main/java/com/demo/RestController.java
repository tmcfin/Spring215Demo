package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private GreetInterface greeter1;

    @Autowired
    @Qualifier(value = "friendlyGreeter")
    private GreetInterface friendly;

    @Autowired
    private GreetAgain greetagain;

    @Autowired(required=false)
    private NotActuallyABean notABean;

    @RequestMapping("/hello")
    public String hello() {
        return greeter1.greet();
    }

    @RequestMapping("/hellofriendly")
    public String helloFriendly() {
        return friendly.greet();
    }

    @RequestMapping("/helloagain")
    public String helloAgain() { return greetagain.greet();
    }
}
