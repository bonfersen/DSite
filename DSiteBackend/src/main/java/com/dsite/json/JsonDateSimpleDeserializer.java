package com.dsite.json;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Created by lbustamante
 */
public class JsonDateSimpleDeserializer extends JsonDeserializer<Date> {
	
	private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        // parse to a LocalDateTime
        LocalDateTime dt = LocalDateTime.parse(jsonParser.getText(), fmt);
        // the date/time is in the default timezone
        Timestamp ts = Timestamp.from(dt.atZone(ZoneId.systemDefault()).toInstant());
        Date date = new Date(ts.getTime()); 
        return date;
    }
}