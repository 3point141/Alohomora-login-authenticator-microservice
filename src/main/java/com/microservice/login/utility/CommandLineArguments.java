package com.microservice.login.utility;

public class CommandLineArguments {

    private String connectionURL;
    private String username;
    private String password;

    public CommandLineArguments(){ }

    public String getConnectionURL() {
        return connectionURL;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder {

        CommandLineArguments commandLineArguments = new CommandLineArguments();

        public Builder withConnectionUrl(String connectionUrl) {
            try {
                commandLineArguments.connectionURL = connectionUrl;
            } catch (NullPointerException e) {
                throw new RuntimeException("Database Connection URL cannot be null");
            }
            return this;
        }

        public Builder withUserName(String userName) {
            try {
                commandLineArguments.username = userName;
            } catch (NullPointerException e) {
                throw new RuntimeException("Username cannot be null");
            }
            return this;
        }

        public Builder withPassword(String password) {
            try {
                commandLineArguments.password = password;
            } catch (NullPointerException e) {
                throw new RuntimeException("Password Cannot be null");
            }
            return this;
        }

        public CommandLineArguments build() {
            return commandLineArguments;
        }
    }
}
