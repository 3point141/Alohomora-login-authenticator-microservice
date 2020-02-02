package com.microservice.login.utility;

import org.apache.commons.cli.*;

public class CommandLineParser {

    private static final String DATABASE_URL = "d";
    private static final String USERNAME = "u";
    private static final String PASSWORD = "p";

    private static Options options = new Options();

    static {
        options.addOption(DATABASE_URL, true,"MYSQL server Database URL");
        options.addOption(USERNAME, true,"Username to connect to database.\n");
        options.addOption(PASSWORD,  true,"Password to database");
    }

    public CommandLineArguments parse(String[] args){
        org.apache.commons.cli.CommandLineParser parser = new DefaultParser();
        try {
            return toCommandLineArguments(parser.parse(options, args));
        } catch (ParseException e) {
            e.printStackTrace();
            System.exit(9);
            return null;
        }
    }

    private CommandLineArguments toCommandLineArguments(CommandLine commandLine) {

        final CommandLineArguments.Builder builder = new CommandLineArguments.Builder();

        if (commandLine.hasOption(DATABASE_URL)) {
            builder.withConnectionUrl(commandLine.getOptionValue(DATABASE_URL));
        }

        if (commandLine.hasOption(USERNAME)) {
            builder.withUserName(commandLine.getOptionValue(USERNAME));
        }

        if (commandLine.hasOption(PASSWORD)) {
            builder.withPassword(commandLine.getOptionValue(PASSWORD));
        }

        return builder.build();
    }
}
