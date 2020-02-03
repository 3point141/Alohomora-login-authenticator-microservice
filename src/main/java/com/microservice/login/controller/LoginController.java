package com.microservice.login.controller;

import com.microservice.login.model.Login;
import com.microservice.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login/table/{tableName}")
    public boolean authenticateLogin(@RequestBody Login login, @PathVariable String tableName) {
        if(null!=login) {
            try {
                return loginService.authenticateLogin(login, tableName);
            } catch (SQLException e) {
                return false;
            }
        }
        return false;
    }
}
