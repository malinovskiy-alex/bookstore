package com.example.bookstore.serializer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class BirthdayDateSerializer extends JsonSerializer<LocalDate> {
  @Override
  public void serialize(
    LocalDate date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
    Map<String, Integer> dateOutput = new HashMap<>();
    dateOutput.put("year", date.getYear());
    dateOutput.put("month", date.getMonthValue());
    dateOutput.put("day", date.getDayOfMonth());
    jsonGenerator.writeObject(dateOutput);
  }
}
