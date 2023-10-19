package org.neoris.microservices.clients.application.client;

import lombok.AllArgsConstructor;
import org.neoris.microservices.clients.domain.entity.Client;
import org.neoris.microservices.clients.domain.entity.enums.ProcessClientTypeEnum;
import org.neoris.microservices.clients.domain.service.client.ClientDeleteService;
import org.neoris.microservices.clients.domain.service.client.ClientGetService;
import org.neoris.microservices.clients.domain.service.client.anotation.CreateClientSend;

@AllArgsConstructor
public class DeleteClientService {

  private final ClientDeleteService clientDeleteService;
  private final ClientGetService clientGetService;

  @CreateClientSend(type = ProcessClientTypeEnum.DELETE)
  public Client delete(String id) {
    Client client = clientGetService.getByDocumentId(id);
    clientDeleteService.delete(client.getId());
    return client;
  }

}
