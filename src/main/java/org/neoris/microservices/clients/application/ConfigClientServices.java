package org.neoris.microservices.clients.application;

import java.util.List;
import org.neoris.microservices.clients.application.client.DeleteClientService;
import org.neoris.microservices.clients.application.client.GetClientService;
import org.neoris.microservices.clients.application.client.SaveClientService;
import org.neoris.microservices.clients.application.client.UpdateClientService;
import org.neoris.microservices.clients.application.event.SendClientToQueueService;
import org.neoris.microservices.clients.domain.service.client.ClientDeleteService;
import org.neoris.microservices.clients.domain.service.client.ClientGetService;
import org.neoris.microservices.clients.domain.service.client.ClientSaveService;
import org.neoris.microservices.clients.domain.service.client.ClientUpdateService;
import org.neoris.microservices.clients.domain.service.event.ProcessPublisherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClientServices {

  @Bean
  public DeleteClientService deleteClientService(ClientDeleteService clientDeleteService,
      ClientGetService clientGetService) {
    return new DeleteClientService(clientDeleteService, clientGetService);
  }

  @Bean
  public GetClientService getClientService(ClientGetService clientGetService) {
    return new GetClientService(clientGetService);
  }

  @Bean
  public SaveClientService saveClientService(ClientSaveService clientSaveService) {
    return new SaveClientService(clientSaveService);
  }

  @Bean
  public UpdateClientService updateClientService(ClientUpdateService clientUpdateService) {
    return new UpdateClientService(clientUpdateService);
  }

  @Bean
  public SendClientToQueueService sendClientToQueueService(
      List<ProcessPublisherService> processPublisherService) {
    return new SendClientToQueueService(processPublisherService);
  }
}
