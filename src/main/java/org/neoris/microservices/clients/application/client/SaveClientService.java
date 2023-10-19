package org.neoris.microservices.clients.application.client;

import lombok.AllArgsConstructor;
import org.neoris.microservices.clients.domain.entity.Client;
import org.neoris.microservices.clients.domain.entity.enums.ProcessClientTypeEnum;
import org.neoris.microservices.clients.domain.service.client.ClientSaveService;
import org.neoris.microservices.clients.domain.service.client.anotation.CreateClientSend;

@AllArgsConstructor
public class SaveClientService {

  private final ClientSaveService clientSaveService;

  @CreateClientSend(type = ProcessClientTypeEnum.CREATE)
  public Client save(Client client) {
    client.setStatus(true);
    return clientSaveService.save(client);
  }

}
