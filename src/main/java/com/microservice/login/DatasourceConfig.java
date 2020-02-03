package com.microservice.login;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url(LoginApplication.getConnectionUrl())
                .username(LoginApplication.getUSERNAME())
                .password(LoginApplication.getPASSWORD())
                .build();
    }
}
