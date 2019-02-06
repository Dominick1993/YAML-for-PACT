package com.labuda.yfp.pact3;

public class Participant {

    /**
     * Participant name
     */
    private String name;

    public Participant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                '}';
    }

}
