package org.neoris.microservices.clients.infrastructure.aspect.client;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.neoris.microservices.clients.application.event.SendClientToQueueService;
import org.neoris.microservices.clients.domain.entity.Client;
import org.neoris.microservices.clients.domain.service.client.anotation.CreateClientSend;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class ClientAspect {

  private final SendClientToQueueService sendClientToQueueService;

  @AfterReturning(value = "@annotation(createClientSend)", returning = "client")
  public void sendToQueue(CreateClientSend createClientSend,
      Client client) {
    sendClientToQueueService.send(client, createClientSend.type());
  }
}
