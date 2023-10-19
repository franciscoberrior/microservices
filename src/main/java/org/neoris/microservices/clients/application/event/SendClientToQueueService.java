package org.neoris.microservices.clients.application.event;

import java.util.List;
import lombok.AllArgsConstructor;
import org.neoris.microservices.clients.domain.entity.Client;
import org.neoris.microservices.clients.domain.entity.enums.ProcessClientTypeEnum;
import org.neoris.microservices.clients.domain.service.event.ProcessPublisherService;

@AllArgsConstructor
public class SendClientToQueueService {

  private final List<ProcessPublisherService> processPublisherService;

  public void send(Client client, ProcessClientTypeEnum type){
    processPublisherService.stream().filter(pps -> pps.type().equals(type)).findFirst()
        .orElseThrow(RuntimeException::new).execute(client);
  }
}
