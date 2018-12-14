package com.example.demo.product;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@SuppressWarnings("unused")
@Component
public class JsonDateSerializer extends JsonSerializer<Date>{
private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
@Override
public void serialize(Date date, JsonGenerator gen, SerializerProvider provider)
throws IOException {
String formattedDate = dateFormat.format(date);
gen.writeString(formattedDate);
}
}