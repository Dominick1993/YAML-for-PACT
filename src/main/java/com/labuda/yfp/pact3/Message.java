package com.labuda.yfp.pact3;

import org.apache.commons.lang3.tuple.ImmutablePair;

/**
 * Class wrapping binary messages
 */
public class Message {

    /**
     * Message description
     */
    private String description;

    /**
     * Provider state
     */
    private String providerState;

    /**
     * Message content
     */
    private ImmutablePair<String, String> content;

    /**
     * Message related metadata
     */
    private MessageMetadata metadata;

    public Message() {
    }

    public String getDescription() {
        return description;
    }

    public String getProviderState() {
        return providerState;
    }

    public ImmutablePair<String, String> getContent() {
        return content;
    }

    public MessageMetadata getMetadata() {
        return metadata;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProviderState(String providerState) {
        this.providerState = providerState;
    }

    public void setContent(ImmutablePair<String, String> content) {
        this.content = content;
    }

    public void setMetadata(MessageMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "Message{" +
                "description='" + description + '\'' +
                ", providerState='" + providerState + '\'' +
                ", content=" + content +
                ", metadata=" + metadata +
                '}';
    }
}
