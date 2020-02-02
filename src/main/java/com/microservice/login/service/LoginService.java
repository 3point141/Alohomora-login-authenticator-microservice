package com.microservice.login.service;

import com.microservice.login.dao.UserDAO;
import com.microservice.login.model.Login;
import com.microservice.login.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserDAO userDAO;

    public boolean authenticateLogin(Login login) {
        User user = userDAO.getUserByUsername(login.getUsername());
        return null != user && login.getPassword().equals(user.getPassword());
    }
}
