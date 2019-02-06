package com.labuda.yfp.pact3;

import java.util.Map;

/**
 * Class wrapping all matching rules
 */
public class MatchingRules {

    /**
     * Body-matching rules
     */
    private Map<String, Matchers> body;

    public MatchingRules() {
    }

    public Map<String, Matchers> getBody() {
        return body;
    }

    public void setBody(Map<String, Matchers> body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "MatchingRules{" +
                "body=" + body +
                '}';
    }
}
