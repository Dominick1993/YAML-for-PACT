package com.labuda.yfp.pact3;

import java.util.List;

/**
 * Pact representation of its version 3 specification
 *
 * @see <a href="https://github.com/pact-foundation/pact-specification/blob/version-3/README.md">https://github.com/pact-foundation/pact-specification/blob/version-3/README.md</a>
 */
public class Pact3 {

    private Participant provider;

    private Participant consumer;

    private List<Message> messages;

    private List<Interaction> interactions;

    private Metadata metadata;

    public Pact3() {
    }

    public Participant getConsumer() {
        return consumer;
    }

    public Participant getProvider() {
        return provider;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<Interaction> getInteractions() {
        return interactions;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setConsumer(Participant consumer) {
        this.consumer = consumer;
    }

    public void setProvider(Participant provider) {
        this.provider = provider;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void setInteractions(List<Interaction> interactions) {
        this.interactions = interactions;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "Pact3{" +
                "consumer=" + consumer +
                ", provider=" + provider +
                ", messages=" + messages +
                ", interactions=" + interactions +
                ", metadata=" + metadata +
                '}';
    }
}
