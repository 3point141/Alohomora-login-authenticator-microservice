package com.microservice.login.service;

import com.microservice.login.DatasourceConfig;
import com.microservice.login.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

@Service
public class LoginService {

    @Autowired
    DatasourceConfig datasourceConfig;

    private ResultSet fetchFromTable(String tableName, String username) throws SQLException {
        Connection connection = datasourceConfig.datasource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM "+tableName+" where username = '"+username+"\'");
        results.next();
        return results;

    }

    public boolean authenticateLogin(Login login, String tableName) throws SQLException {
        ResultSet resultSet = fetchFromTable(tableName, login.getUsername());
        if (Objects.nonNull(resultSet)) {
            return resultSet.getString("password").equals(login.getPassword());
        }
        return false;
    }
}
