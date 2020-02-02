package com.microservice.login.controller;

import com.microservice.login.model.Login;
import com.microservice.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public boolean authenticateLogin(@RequestBody Login login) {
        if(null!=login) {
            return loginService.authenticateLogin(login);
        }
        return false;
    }
}
