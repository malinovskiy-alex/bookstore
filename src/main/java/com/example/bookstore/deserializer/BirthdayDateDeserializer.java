package com.example.bookstore.deserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class BirthdayDateDeserializer extends StdDeserializer<LocalDate> {
  public BirthdayDateDeserializer() {
    this(null);
  }

  protected BirthdayDateDeserializer(Class<Date> vc) {
    super(vc);
  }

  @Override
  public LocalDate deserialize(
    JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
    ObjectCodec codec = jsonParser.getCodec();
    JsonNode node = codec.readTree(jsonParser);
    if (node == null) {
      return null;
    }
    if (node.has("year")) {
      Integer year = node.get("year").asInt();
      if (node.has("month")) {
        Integer month = node.get("month").asInt();
        if (node.has("day")) {
          Integer date = node.get("day").asInt();
          return LocalDateTime.of(year, month, date, 0, 0).toLocalDate();
        }
      }
    }

    return null;
  }
}
