package com.powernode.impl;

import com.powernode.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * ty
 * 2020/8/18
 */
@Component
public class Controller {
    @Autowired
    private UserService service;

    @Value("${SESSION}")
    private String SESSION_USER;

    public void setService(UserService service) {
        this.service = service;
    }

    public void show(){
        System.out.println("controller");
        System.out.println("session="+SESSION_USER);
        service.show();
    }
}
