package com.labuda.yfp;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.labuda.yfp.pact3.Pact3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class App {

    private final static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());

        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
        jsonMapper.setSerializationInclusion(Include.NON_NULL);

        try {
            Pact3 pact = yamlMapper.readValue(new File("test.yml"), Pact3.class);
            jsonMapper.writeValue(new File("test.json"), pact);
        } catch (Exception e) {
            logger.error("Something failed", e);
        }
    }
}
