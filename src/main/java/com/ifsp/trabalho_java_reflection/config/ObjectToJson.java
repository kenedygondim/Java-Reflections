package com.ifsp.trabalho_java_reflection.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ifsp.trabalho_java_reflection.config.Transformator;

public class ObjectToJson {
    public static <T> JsonNode toJson(Object source, Class<T> targetClass) throws Exception {
        if (source == null) {
            return null;
        }

        T target = Transformator.map(source, targetClass);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper.valueToTree(target);
    }
}
