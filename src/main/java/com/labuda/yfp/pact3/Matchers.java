package com.labuda.yfp.pact3;

import java.util.List;
import java.util.Map;

/**
 * Matchers class
 * <p>
 * Represents a basic building block to add multiple matchers
 */
public class Matchers {

    /**
     * List of matchers
     */
    private List<Map<String, Object>> matchers;

    public Matchers() {
    }

    public List<Map<String, Object>> getMatchers() {
        return matchers;
    }

    public void setMatchers(List<Map<String, Object>> matchers) {
        this.matchers = matchers;
    }

    @Override
    public String toString() {
        return "Matchers{" +
                "matchers=" + matchers +
                '}';
    }
}
