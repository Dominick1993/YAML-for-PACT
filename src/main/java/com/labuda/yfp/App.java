package com.labuda.yfp;

import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private final static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("App is started");

        Options options = new Options();

        Option source = Option.builder("s")
                .longOpt("source")
                .hasArg()
                .argName("sourceDirectory")
                .required()
                .desc("Source directory containing YAML Pact files")
                .build();

        Option destination = Option.builder("d")
                .longOpt("destination")
                .hasArg()
                .argName("destinationDirectory")
                .required()
                .desc("Destination directory for converted files")
                .build();

        Option recursive = Option.builder("r")
                .longOpt("recursive")
                .desc("Use for recursive traversal of source directory")
                .build();

        Option help = Option.builder("h")
                .longOpt("help")
                .desc("Prints help")
                .build();

        options.addOption(source).addOption(destination).addOption(recursive).addOption(help);

        try {
            CommandLineParser commandLineParser = new DefaultParser();
            CommandLine commandLine = commandLineParser.parse(options, args);

            if (commandLine.hasOption("h")) {
                printHelp(options);
                System.exit(0);
            }

            String sourcePath = commandLine.getOptionValue("s");
            String destinationPath = commandLine.getOptionValue("d");
            boolean recursiveFlag = commandLine.hasOption("r");

            YamlPactConverter yamlPactConverter = new YamlPactConverter(sourcePath, destinationPath, recursiveFlag);
            yamlPactConverter.convertToJsonFiles();

        } catch (ParseException e) {
            logger.error("Wasn't able to parse the provided arguments correctly", e);
            printHelp(options);
        }
    }

    /**
     * Prints help for CLI
     *
     * @param options available options
     */
    private static void printHelp(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.printHelp("YAML for Pact", options);
    }
}
