package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class GreeterConfiguration {

    @Autowired
    private DatabaseConfiguration databaseConfig;

    @Bean
    @Scope(value = "prototype")
    public Greeter greeter() {
        return new Greeter();
    }

//    @Bean
//    @Scope(value = "singleton")
//    public FriendlyGreeter friendlyGreeter() {
//        return new FriendlyGreeter();
//    }
    // changing above bean scope from singleton to request
    // this results in the counter never incrementing above a count of 1
    // result: every request creates a new bean

    // request scope
    // should be initialized for every new request and destroyed when request has ended
    @Bean
    // @Scope can be removed and this bean will have application scope and is initialized
    // immediately upon startup, whereas right now a new instance is initialed for each request
    // Note: if the @Scope below is edited out only the destroy() in the FriendlyGreeter class is called
    //       however, if @PostConstruct is present in that case, afterPropertiesSet method is called.
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public FriendlyGreeter friendlyGreeter() {
        return new FriendlyGreeter(databaseConfig);
    }

}
