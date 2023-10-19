package org.neoris.microservices.accounts.domain.service.client;

import org.neoris.microservices.accounts.domain.entity.Client;

public interface ClientGetService {

  Client get(String id);

}
