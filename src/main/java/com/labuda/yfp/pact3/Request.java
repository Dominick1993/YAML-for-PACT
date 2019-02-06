package com.labuda.yfp.pact3;

import java.util.Map;

/**
 * Request wrapping class
 * <p>
 * Contains info about the consumer request
 */
public class Request {

    /**
     * HTTP(S) method
     */
    private String method;

    /**
     * URI path
     */
    private String path;

    /**
     * Request headers
     */
    private Map<String, String> headers;

    public Request() {
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", headers=" + headers +
                '}';
    }
}
