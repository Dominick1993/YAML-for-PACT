package com.labuda.yfp.pact3;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * Provider response wrapping class
 */
public class Response {

    /**
     * Status code
     */
    private Integer status;

    /**
     * Response headers
     */
    private Map<String, String> headers;

    /**
     * Response body
     */
    private Object body;

    /**
     * Response matching rules
     */
    private MatchingRules matchingRules;

    public Response() {
    }

    public Integer getStatus() {
        return status;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Object getBody() {
        return body;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    /**
     * Sets the body by parsing it from JSON String into the Object, which is then correctly provided
     *
     * @param body JSON String of response body
     */
    public void setBody(String body) {
        try {
            this.body = new ObjectMapper().readValue(body, Object.class);
        } catch (IOException e) {
            // TODO Fix this mess
            this.body = new Object();
        }
    }

    public MatchingRules getMatchingRules() {
        return matchingRules;
    }

    public void setMatchingRules(MatchingRules matchingRules) {
        this.matchingRules = matchingRules;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", headers=" + headers +
                ", body=" + body +
                ", matchingRules=" + matchingRules +
                '}';
    }
}
