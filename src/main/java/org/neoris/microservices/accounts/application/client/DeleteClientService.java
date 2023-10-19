package org.neoris.microservices.accounts.application.client;

import lombok.AllArgsConstructor;
import org.neoris.microservices.accounts.domain.service.client.ClientDeleteService;

@AllArgsConstructor
public class DeleteClientService {

  private final ClientDeleteService clientDeleteService;

  public void delete(Long id) {
    clientDeleteService.delete(id);
  }

}
