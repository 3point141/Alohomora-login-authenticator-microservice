package com.microservice.login.dao;

import com.microservice.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, String> {

    public User getUserByUsername(String username);
}
