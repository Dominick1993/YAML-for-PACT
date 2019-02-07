package com.labuda.yfp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.labuda.yfp.pact3.Pact3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Converts Pact objects to JSON Pact files
 */
public class PactToJson {

    private final static Logger logger = LoggerFactory.getLogger(App.class);

    /** JSON mapper */
    private final static ObjectMapper jsonMapper = new ObjectMapper();

    static {
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
        jsonMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    /**
     * Converts Pact object to formatted JSON String
     *
     * @param pact pact
     * @return JSON String
     */
    public static String convert(Pact3 pact) {
        try {
            return jsonMapper.writeValueAsString(pact);
        } catch (JsonProcessingException e) {
            logger.error("Provided Pact was not serialized to JSON...", e);
        }
        return null;
    }

}
