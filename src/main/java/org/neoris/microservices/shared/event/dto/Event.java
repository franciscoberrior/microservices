package org.neoris.microservices.shared.event.dto;

import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.neoris.microservices.shared.exception.infrastructure.event.InvalidEventException;

@Getter
@Setter
public class Event<T> {

  private static final String EVENT_TYPE = "EVENT_TYPE";
  private static final String CREATION_DATE = "CREATION_DATE";

  private static final Gson GSON = new Gson();

  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(
          "yyyy-MM-dd HH:mm:ss")
      .withZone(ZoneId.of("America/Bogota"));

  private final Map<String, String> headers;
  private T data;
  private final String id;

  public Event(String type, T data) {
    this(type, new HashMap<>(), data);
  }

  public Event(String type, Map<String, String> headers, T data) {
    if (Optional.ofNullable(type).orElse("").trim().isEmpty()) {
      throw new InvalidEventException(String.valueOf(type));
    }
    this.id = UUID.randomUUID().toString();
    this.data = data;
    this.headers = Objects.isNull(headers) ? new HashMap<>() : headers;
    this.headers.put(CREATION_DATE, now());
    this.headers.put(EVENT_TYPE, type);
  }

  private String now() {
    return FORMATTER.format(LocalDateTime.now());
  }

  public String getType() {
    return this.headers.get(EVENT_TYPE);
  }

  public void addHeader(String name, String value) {
    this.headers.putIfAbsent(name, value);
  }

  public void addHeader(Entry<String, String> header) {
    this.headers.putIfAbsent(header.getKey(), header.getValue());
  }

  public void addHeaders(Set<Entry<String, String>> entrySet) {
    entrySet.forEach(this::addHeader);
  }

  public void setEventType(String eventType) {
    this.headers.put(EVENT_TYPE, eventType);
  }

  public Map<String, String> getHeaders() {
    return new HashMap<>(headers);
  }

  public String toJsonData() {
    return GSON.toJson(this);
  }

}