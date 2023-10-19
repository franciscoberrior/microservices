package org.neoris.microservices.clients.application.client;

import lombok.AllArgsConstructor;
import org.neoris.microservices.clients.domain.entity.Client;
import org.neoris.microservices.clients.domain.service.client.ClientGetService;

@AllArgsConstructor
public class GetClientService {

  private final ClientGetService clientGetService;

  public Client getById(String id) {
    return clientGetService.getByDocumentId(id);
  }
}
