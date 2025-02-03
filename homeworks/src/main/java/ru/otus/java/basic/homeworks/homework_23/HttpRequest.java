package ru.otus.java.basic.homeworks.homework_23;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private String rawRequest;
    private HttpMethod method;
    private String uri;
    private String body;
    private Map<String, String> parameters;
    private Map<String, String> headers;
    private Exception errorCause;
    private static final Logger LOGGER = LogManager.getLogger(HttpRequest.class);

    public void setErrorCause(Exception errorCause) {
        this.errorCause = errorCause;
    }

    public Exception getErrorCause() {
        return errorCause;
    }



    public String getRoutingKey() {
        return method + " " + uri;
    }

    public String getUri() {
        return uri;
    }

    public HttpRequest(String rawRequest) {
        this.rawRequest = rawRequest;
        parse();
    }

    public String getBody() {
        return body;
    }

    public String getParameter(String key) {
        return parameters.get(key);
    }
    public boolean containsParameter(String key) {
        return parameters.containsKey(key);
    }
    private void parse() {
        this.parameters = new HashMap<>();
        this.headers = new HashMap<>();
        int startIndex = rawRequest.indexOf(' ');
        int endIndex = rawRequest.indexOf(' ', startIndex + 1);
        this.method = HttpMethod.valueOf(rawRequest.substring(0, startIndex));
        this.uri = rawRequest.substring(startIndex + 1, endIndex);
        if (this.uri.contains("?")) {
            String[] tokens = this.uri.split("[?]");
            this.uri = tokens[0];
            String[] paramsPairs = tokens[1].split("[&]");
            for (String o : paramsPairs) {
                String[] keyValue = o.split("=");
                this.parameters.put(keyValue[0],keyValue[1]);
            }
        }
        rawRequest.lines()
                .skip(1)
                .takeWhile(s -> !s.isBlank())
                .forEach(
                s -> {
                    String[] keyValue =s.split(": ");
                    headers.put(keyValue[0], keyValue[1]);
                }
        );
        this.body = rawRequest.substring(rawRequest.indexOf("\r\n\r\n") + 4,rawRequest.length());
    }

    public void info() {
        LOGGER.info("METHOD: " + method);
        LOGGER.info("URI: " + uri);
        LOGGER.info("HEADERS: " + headers);
        LOGGER.info("BODY: " + body);
        LOGGER.debug("Raw request: " + rawRequest);
//        if (showRawRequest) {
//            System.out.println(rawRequest);
//        }
    }
}
