package com.dsite.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Base64;

public class JsonStringByteDeserializer extends JsonDeserializer<byte[]> {

    @Override
    public byte[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    	
        
    	String value = p.getText();
        try {
            if (value!= null && value.equals("Si")) {
                return  new byte[]{1};
            }
            
            return new byte[]{0};
        }
        catch (Exception pe) {
            throw new RuntimeException(pe);
        }
    }

}