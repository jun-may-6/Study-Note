package com.example.structure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.converter.StructuredOutputConverter;

public class CustomConverter implements StructuredOutputConverter<CustomDTO> {
    @Override
    public CustomDTO convert(String source) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(source, CustomDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert AI output to MyCustomObject", e);
        }
    }
    @Override
    public String getFormat(){
        return "JSON";
    }
}
