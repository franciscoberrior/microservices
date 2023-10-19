package org.neoris.microservices.accounts.application.client;

import lombok.AllArgsConstructor;
import org.neoris.microservices.accounts.domain.entity.Client;
import org.neoris.microservices.accounts.domain.service.client.ClientSaveService;

@AllArgsConstructor
public class SaveClientService {

  private final ClientSaveService clientSaveService;

  public void save(Client client) {
    clientSaveService.save(client);
  }

}
