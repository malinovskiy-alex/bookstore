package com.example.bookstore.serializer;

import java.io.IOException;

import com.example.bookstore.domain.user.Gender;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class GenderSerializer extends JsonSerializer<Gender> {

  @Override
  public void serialize(
    Gender gender, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
    jsonGenerator.writeObject(gender.getId());
  }
}
