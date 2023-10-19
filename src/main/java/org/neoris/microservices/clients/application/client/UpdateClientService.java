package org.neoris.microservices.clients.application.client;

import lombok.AllArgsConstructor;
import org.neoris.microservices.clients.domain.entity.Client;
import org.neoris.microservices.clients.domain.entity.enums.ProcessClientTypeEnum;
import org.neoris.microservices.clients.domain.service.client.ClientUpdateService;
import org.neoris.microservices.clients.domain.service.client.anotation.CreateClientSend;

@AllArgsConstructor
public class UpdateClientService {

  private final ClientUpdateService clientUpdateService;

  @CreateClientSend(type = ProcessClientTypeEnum.UPDATE)
  public Client update(Client client){
    return clientUpdateService.update(client);
  }

}
