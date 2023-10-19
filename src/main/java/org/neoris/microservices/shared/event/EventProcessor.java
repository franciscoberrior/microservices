package org.neoris.microservices.shared.event;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.neoris.microservices.shared.event.dto.Event;

@Slf4j
@Getter
public abstract class EventProcessor<T> {

  private final String eventType;

  private final String name;

  private static final String NAME_POSTFIX = "_LISTENER";

  protected EventProcessor(String eventType) {
    this.eventType = eventType;
    this.name = generateName(eventType);
  }

  private String generateName(String eventType) {
    return eventType.concat(NAME_POSTFIX);
  }

  public void accept(Event<String> messageEvent) {
    if (!canProcessType(messageEvent.getType())) {
      logEvent("{} ignore message {} {} ", messageEvent);
      return;
    }
    logEvent("{} processing message {} {} ", messageEvent);
    T entity = readValue(String.valueOf(messageEvent.getData()));
    Event<T> entityEvent = new Event<>(messageEvent.getType(), entity);
    entityEvent.addHeaders(messageEvent.getHeaders().entrySet());
    process(entityEvent);
  }

  public abstract void process(Event<T> messageEvent);

  public abstract T readValue(String content);

  private void logEvent(String pattern, Event<String> messageEvent) {
    log.info(pattern, this.getName(), messageEvent.getType(), messageEvent.getId());
  }

  public boolean canProcessType(String eventType) {
    return this.getEventType().equalsIgnoreCase(eventType);
  }

}