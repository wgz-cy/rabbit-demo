package com.example.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Type;

@Slf4j
public class JsonConverter {

    private static Gson gson = new Gson();

    private static ObjectMapper objectMapper = new ObjectMapper();

    /*@Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        JsonConverter.objectMapper = objectMapper;
    }*/

    /**
     * typeOfT获得方式：new TypeToken&lt;T&gt;() {}.getType()；T的举例：List<Long>、List<Map<String,Object>等等.
     */
    public static <T> T fromJson(String json, Type typeOfT) throws Exception {
        T result;
        try {
            result = gson.fromJson(json, typeOfT);
        } catch (JsonSyntaxException e) {
            log.error(String.format("【JSON转换错误】JSON转换到对象错误, string=%s", json), e);
            throw new Exception("对象转换到JSON错误");
        }
        return result;
    }

    public static <T> T fromJson(String json, Class<T> clazzOfT) throws Exception {
        T result;
        try {
            result = gson.fromJson(json, clazzOfT);
        } catch (JsonSyntaxException e) {
            log.error(String.format("【JSON转换错误】JSON转换到对象错误, string=%s", json), e);
            throw new Exception("对象转换到JSON错误");
        }
        return result;
    }

    public static String toJson(Object object) throws Exception {
        String result;
        try {
            result = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error(String.format("【JSON转换错误】对象转换到JSON错误, object=%s", object), e);
            throw new Exception("对象转换到JSON错误");
        }
        return result;
    }

    public static JsonNode fromJson(String json) throws Exception {
        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(json);
        } catch (IOException e) {
            log.error(String.format("【JSON转换错误】JSON转换到对象错误, string=%s", json), e);
            throw new Exception("对象转换到JSON错误");
        }
        return jsonNode;
    }
}
