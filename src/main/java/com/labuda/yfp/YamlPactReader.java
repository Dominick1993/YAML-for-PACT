package com.labuda.yfp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.labuda.yfp.pact3.Pact3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Parser for YAML pact files
 */
public class YamlPactReader {

    private final static Logger logger = LoggerFactory.getLogger(YamlPactReader.class);

    /**
     * Mapper configured to read YAML files
     */
    private final static ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());

    /**
     * Parses the YAML into a Pact object
     *
     * @param file yaml file
     * @return Pact object or null if file read fails
     */
    public static Pact3 parsePact(File file) {
        try {
            return yamlMapper.readValue(file, Pact3.class);
        } catch (IOException e) {
            logger.error("File [" + file + "] could not be read.", e);
        }
        return null;
    }

    /**
     * Parses the YAML file into a Pact object
     *
     * @param path file path
     * @return Pact object or null if file read fails
     */
    public static Pact3 parsePact(Path path) {
        return parsePact(path.toFile());
    }

    /**
     * Parses the YAML file into a Pact object
     *
     * @param filePath file path
     * @return Pact object or null if file read fails
     */
    public static Pact3 parsePact(String filePath) {
        return parsePact(new File(filePath));
    }

}
