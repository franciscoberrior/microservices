package org.neoris.microservices.accounts.infrastructure.event.context;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.neoris.microservices.shared.event.EventProcessor;
import org.neoris.microservices.shared.event.dto.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ContextListener {

  @Autowired
  private List<EventProcessor<?>> eventProcessors;

  @EventListener(condition = "#event.headers['CONTEXT'] == 'INTERNAL'")
  public void handleInternalEvent(Event<?> event) {
    defaultConsumer().accept(event);
  }

  private Consumer<Event<?>> defaultConsumer() {
    return event -> {
      final Optional<EventProcessor<?>> eventProcessor = eventProcessors.stream()
          .filter(x -> x.canProcessType(event.getType())).findFirst();
      if (!eventProcessor.isPresent()) {
        log.error("Internal processor for type {} not found", event.getType());
        return;
      }
      EventProcessor<?> processor = eventProcessor.get();
      log.info(" {} Selected for internal event processing {}:({})",
          processor.getClass().getSimpleName(),
          event.getType(),
          event.getId());
      processor.accept((Event<String>) event);
    };
  }

}