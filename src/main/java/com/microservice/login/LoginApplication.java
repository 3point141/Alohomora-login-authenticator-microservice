package com.microservice.login;

import com.microservice.login.utility.CommandLineArguments;
import com.microservice.login.utility.CommandLineParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

@SpringBootApplication
public class LoginApplication {

	public static void main(String[] args) throws IOException {
		final CommandLineParser commandLineParser = new CommandLineParser();
		final CommandLineArguments commandLine = commandLineParser.parse(args);
		setDatabaseConnection(commandLine);
		SpringApplication.run(LoginApplication.class, args);
	}

	private static void setDatabaseConnection(CommandLineArguments commandLineArguments) throws IOException {
		String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
		String appConfigPath = rootPath + "application.properties";
		Properties appProps = new Properties();
		/*FileInputStream in = new FileInputStream(appConfigPath);
		appProps.load(in);
		in.close();*/

		FileOutputStream out = new FileOutputStream(appConfigPath);
		appProps.setProperty("spring.datasource.url", commandLineArguments.getConnectionURL());
		appProps.setProperty("spring.datasource.username", commandLineArguments.getUsername());
		appProps.setProperty("spring.datasource.password", commandLineArguments.getPassword());
		appProps.store(out, null);
		out.close();
	}

}
