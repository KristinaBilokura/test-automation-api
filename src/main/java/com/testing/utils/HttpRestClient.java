package com.testing.utils;

import io.restassured.response.Response;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class HttpRestClient {

    private String baseUri;
    private String host;
    private Response response;
    private int basePort;

    public HttpRestClient(String baseUri, String host, int basePort) {
        this.baseUri = baseUri;
        this.host = host;
        this.basePort = basePort;
    }

    public String getBaseUri() {
        return baseUri;
    }

    public String getHost() {
        return host;
    }

    public Response getResponse() {
        return response;
    }

    public int getBasePort() {
        return basePort;
    }

    public String getBaseUrl() {
        return getBaseUri() + getHost() + ":" + getBasePort();
    }


    public Response callHttpGet(String endPointUrl) {
        response = null;
        try {
            return given().
                    get(new URL(getBaseUrl() + endPointUrl)).
                    prettyPeek();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return response;
    }


    public Response callHttpGet(String endPointUrl, Map<String, String> cookies, Map<String, String> headers) {
        response = null;
        try {
            return given().
                    cookies(cookies).
                    headers(headers).
                    get(new URL(getBaseUrl() + endPointUrl)).
                    prettyPeek();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return response;
    }


    public Response callHttpGet(String endPointUrl, String param, Map<String, String> headers) {
        response = null;
        try {
            return given().
                    headers(headers).
                    formParam(param).
                    get(new URL(getBaseUrl() + endPointUrl)).
                    prettyPeek();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return response;
    }


    public Response callHttpGet(String endPointUrl, String param, Map<String, String> cookies, Map<String, String> headers) {
        response = null;
        try {
            return given().
                    cookies(cookies).
                    headers(headers).
                    formParam(param).
                    get(new URL(getBaseUrl() + endPointUrl)).
                    prettyPeek();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return response;
    }


    public Response callHttpPost(String endPointUrl, String requestBody, Map<String, String> headers) {
        response = null;
        try {
            return given().
                    headers(headers).
                    body(requestBody).
                    post(new URL(getBaseUrl() + endPointUrl)).
                    prettyPeek();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return response;
    }


    public Response callHttpPost(String endPointUrl) {
        response = null;
        try {
            return given().
                    post(new URL(getBaseUrl() + endPointUrl));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return response;
    }


    public Response callHttpPost(String endPointUrl, String requestBody, Map<String, String> cookies,
                                 Map<String, String> headers) {
        response = null;
        try {
            return given().
                    cookies(cookies).
                    headers(headers).
                    body(requestBody).
                    post(new URL(getBaseUrl() + endPointUrl)).
                    prettyPeek();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return response;
    }


    public Response callHttpPost(String endPointUrl, String requestBody, String param, Map<String, String> cookies,
                                 Map<String, String> headers) {
        response = null;
        try {
            return given().
                    cookies(cookies).
                    headers(headers).
                    body(requestBody).
                    formParam(param).
                    post(new URL(getBaseUrl() + endPointUrl)).
                    prettyPeek();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return response;
    }


    public Response callHttpPost(String endPointUrl, Map<String, String> cookies, Map<String, String> headers) {
        response = null;
        try {
            return given().
                    cookies(cookies).
                    headers(headers).
                    post(new URL(getBaseUrl() + endPointUrl)).
                    prettyPeek();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return response;
    }


    public Response callHttpPut(String endPointUrl, String body, Map<String, String> cookies,
                                Map<String, String> headers) {
        response = null;
        try {
            return given().
                    cookies(cookies).
                    headers(headers).
                    body(body).
                    put(new URL(getBaseUrl() + endPointUrl)).
                    prettyPeek();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return response;
    }

    public Response callHttpPut(String endPointUrl, Map<String, String> cookies, Map<String, String> headers) {
        response = null;
        try {
            return given().
                    cookies(cookies).
                    headers(headers).
                    put(new URL(getBaseUrl() + endPointUrl)).
                    prettyPeek();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return response;
    }

    public Response callHttpPut(String endPointUrl, Map<String, String> headers) {
        response = null;
        try {
            return given().
                    headers(headers).
                    put(new URL(getBaseUrl() + endPointUrl)).
                    prettyPeek();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return response;
    }


    public Response callHttpDelete(String endPointUrl, Map<String, String> headers) {
        response = null;
        try {
            return given().
                    headers(headers).
                    delete(new URL(getBaseUrl() + endPointUrl));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return response;
    }


    public Response callHttpDelete(String endPointUrl, Map<String, String> cookies, Map<String, String> headers) {
        response = null;
        try {
            return given().
                    cookies(cookies).
                    headers(headers).
                    delete(new URL(getBaseUrl() + endPointUrl));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return response;
    }


    public void resetProp() {
        RestAssured.reset();
    }
}