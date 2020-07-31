package com.testing.jsonfactory.jsonconverters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jayway.restassured.response.Response;
import com.testing.jsonfactory.ServiceAResponse;

import java.io.IOException;
import java.util.List;

public class JsonConverter {
    public static <T> T convertJsonToObject(Response response, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        T obj = null;
        try {
            obj = objectMapper.readValue(response.body().asString(), clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static <T> String convertObjectToJson(T object) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public static List<ServiceAResponse> convertJsonToListOfUsers(Response response) {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<ServiceAResponse>> infoList = new TypeReference<List<ServiceAResponse>>() {
        };
        List<ServiceAResponse> jsonToInfoList = null;
        try {
            jsonToInfoList = objectMapper.readValue(response.body().asString(), infoList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonToInfoList;
    }
}
