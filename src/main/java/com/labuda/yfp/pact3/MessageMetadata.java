package com.labuda.yfp.pact3;

/**
 * Class wrapping message metadata
 */
public class MessageMetadata {

    /**
     * Message content type
     */
    private String contentType;

    public MessageMetadata() {
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "MessageMetadata{" +
                "contentType='" + contentType + '\'' +
                '}';
    }
}
