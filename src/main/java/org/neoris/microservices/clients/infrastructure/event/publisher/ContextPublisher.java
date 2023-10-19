package org.neoris.microservices.clients.infrastructure.event.publisher;

import java.util.HashMap;
import org.neoris.microservices.shared.event.dto.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ContextPublisher {

  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;

  public <T> void publish(final Event<T> event) {
    HashMap<String, String> headers = new HashMap<>();
    headers.putAll(event.getHeaders());
    headers.put("CONTEXT", "INTERNAL");
    Event<?> internalEvent = new Event<>(event.getType(), headers, event.getData());
    applicationEventPublisher.publishEvent(internalEvent);
  }

}