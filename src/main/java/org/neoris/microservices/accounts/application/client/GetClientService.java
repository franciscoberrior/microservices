package org.neoris.microservices.accounts.application.client;

import lombok.AllArgsConstructor;
import org.neoris.microservices.accounts.domain.entity.Client;
import org.neoris.microservices.accounts.domain.service.client.ClientGetService;

@AllArgsConstructor
public class GetClientService {

  private final ClientGetService clientGetService;

  public Client getById(String id) {
    return clientGetService.get(id);
  }
}
