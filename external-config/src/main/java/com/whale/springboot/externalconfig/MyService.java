package com.whale.springboot.externalconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MyService {

    private final AcmeProperties properties;

    @Autowired
    public MyService(AcmeProperties properties) {
        this.properties = properties;
    }

    @PostConstruct
    public void openConnection() {
        System.out.println(this.properties.getRemoteAddress());
        System.out.println(this.properties.getSecurity().getUsername());
        System.out.println(this.properties.getSecurity().getRoles());
        System.out.println(this.properties.getSecurity().getPassword());
    }
}