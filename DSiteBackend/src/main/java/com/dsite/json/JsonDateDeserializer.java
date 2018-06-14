package com.dsite.json;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Created by lbustamante
 */
public class JsonDateDeserializer extends JsonDeserializer<Date> {
    private SimpleDateFormat formatter =
            new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    	String dateAsString = p.getText();
        try {
            if (!StringUtils.hasText(dateAsString)) {
                return null;
            }
            if(dateAsString.length()>10){
                return formatter.parse(dateAsString);
            }
            return formatter.parse(dateAsString);

        }
        catch (ParseException pe) {
            throw new RuntimeException(pe);
        }

	}

   /* @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeString(formatter.format(value));
    }*/

}