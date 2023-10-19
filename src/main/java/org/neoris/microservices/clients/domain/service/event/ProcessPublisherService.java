package org.neoris.microservices.clients.domain.service.event;

import org.neoris.microservices.clients.domain.entity.Client;
import org.neoris.microservices.clients.domain.entity.enums.ProcessClientTypeEnum;

public interface ProcessPublisherService{

  ProcessClientTypeEnum type();
  void execute(Client client);
}
