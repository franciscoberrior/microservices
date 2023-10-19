package org.neoris.microservices.clients.domain.service.client;

import org.neoris.microservices.clients.domain.entity.Client;

public interface ClientGetService {
  Client getByDocumentId(String id);

}
