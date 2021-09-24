package com.example.electro.controller;


import com.example.electro.dataobjects.UserApplianceDO;
import com.example.electro.entity.User;
import com.example.electro.service.AppService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    private AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        return appService.hello();
    }

    @GetMapping(path = "/users/{userId}/devices", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserApplianceDO findBy(@PathVariable Long userId) {
        UserApplianceDO userApplianceDO = appService.findBy(userId);
        return userApplianceDO;
    }

}
