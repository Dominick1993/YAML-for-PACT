package com.labuda.yfp.pact3;

/**
 * Interaction class
 * <p>
 * Describes basic interaction between the provider and consumer
 */
public class Interaction {

    /**
     * Short description of the interaction
     */
    private String description;

    /**
     * Consumer request
     */
    private Request request;

    /**
     * Provider response
     */
    private Response response;

    public Interaction() {
    }

    public String getDescription() {
        return description;
    }

    public Request getRequest() {
        return request;
    }

    public Response getResponse() {
        return response;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Interaction{" +
                "description='" + description + '\'' +
                ", request=" + request +
                ", response=" + response +
                '}';
    }
}
