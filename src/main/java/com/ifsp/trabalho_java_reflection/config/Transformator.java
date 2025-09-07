package com.ifsp.trabalho_java_reflection.config;

import java.lang.reflect.Field;

public class Transformator {
    public static <T> T map(Object source, Class<T> targetClass) {
        try {
            T target = targetClass.getDeclaredConstructor().newInstance();
            for (Field targetField : targetClass.getDeclaredFields()) {
                targetField.setAccessible(true);
                try {
                    Field sourceField = source.getClass().getDeclaredField(targetField.getName());
                    sourceField.setAccessible(true);
                    Object value = sourceField.get(source);
                    targetField.set(target, value);
                } catch (NoSuchFieldException ex) { System.out.println("Campo nao existe"); }
            }
            return target;
        } catch (Exception e) { throw new RuntimeException("Erro ao realizar mapeamento: " + e.getMessage()); }
    }
}
