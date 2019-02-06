package com.labuda.yfp.pact3;

/**
 * Pact metadata
 */
public class Metadata {

    /**
     * Pact specification
     */
    private PactSpecification pactSpecification;

    public Metadata() {
    }

    public PactSpecification getPactSpecification() {
        return pactSpecification;
    }

    public void setPactSpecification(PactSpecification pactSpecification) {
        this.pactSpecification = pactSpecification;
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "pactSpecification=" + pactSpecification +
                '}';
    }
}
