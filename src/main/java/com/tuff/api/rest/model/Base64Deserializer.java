package com.tuff.api.rest.model;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Deserializer extends JsonDeserializer<Object> implements ContextualDeserializer {

    private Class<?> resultClass;

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext context, BeanProperty property) throws JsonMappingException {
        this.resultClass = property.getType().getRawClass();
        return this;
    }

    @Override
    public Object deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
        String value = parser.getValueAsString();
        Base64.Decoder decoder = Base64.getDecoder();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            byte[] decodedValue = decoder.decode(value);
            String s = new String(decodedValue, StandardCharsets.UTF_8);
            return objectMapper.readValue(s.replace("\"{", "{").replace("\\", "").replace("}\"", "}").getBytes(), this.resultClass);
        } catch (IllegalArgumentException | JsonParseException e) {
            String fieldName = parser.getParsingContext().getCurrentName();
            Class<?> wrapperClass = parser.getParsingContext().getCurrentValue().getClass();

            throw new InvalidFormatException(
                parser,
                String.format("Value for '%s' is not a base64 encoded JSON", fieldName),
                value,
                wrapperClass
            );
        }
    }
}