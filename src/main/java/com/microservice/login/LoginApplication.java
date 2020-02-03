package com.microservice.login;

import com.microservice.login.utility.CommandLineArguments;
import com.microservice.login.utility.CommandLineParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoginApplication {

	private static String CONNECTION_URL;
	private static String USERNAME;
	private static String PASSWORD;

	public static void main(String[] args) {
		final CommandLineParser commandLineParser = new CommandLineParser();
		final CommandLineArguments commandLine = commandLineParser.parse(args);
		setDatabaseConnection(commandLine);
		SpringApplication.run(LoginApplication.class, args);
	}

	private static void setDatabaseConnection(CommandLineArguments commandLineArguments) {
		CONNECTION_URL = commandLineArguments.getConnectionURL();
		USERNAME = commandLineArguments.getUsername();
		PASSWORD = commandLineArguments.getPassword();
	}

	public static String getConnectionUrl() {
		return CONNECTION_URL;
	}

	public static String getUSERNAME() {
		return USERNAME;
	}

	public static String getPASSWORD() {
		return PASSWORD;
	}

}
