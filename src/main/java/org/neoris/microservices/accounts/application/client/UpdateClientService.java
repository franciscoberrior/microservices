package org.neoris.microservices.accounts.application.client;

import lombok.AllArgsConstructor;
import org.neoris.microservices.accounts.domain.entity.Client;
import org.neoris.microservices.accounts.domain.service.client.ClientUpdateService;

@AllArgsConstructor
public class UpdateClientService {

  private final ClientUpdateService clientUpdateService;

  public void update(Client client) {
    clientUpdateService.update(client);
  }

}
