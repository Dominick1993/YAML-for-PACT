package com.labuda.yfp.pact3;

/**
 * Pact specification metadata
 */
public class PactSpecification {

    /**
     * Version of a pact specification
     */
    private String version;

    public PactSpecification() {
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "PactSpecification{" +
                "version='" + version + '\'' +
                '}';
    }
}
