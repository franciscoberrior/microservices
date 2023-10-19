package org.neoris.microservices.accounts.domain.service.movement;

import org.neoris.microservices.accounts.domain.entity.Movement;

public interface MovementSaveService {

  Movement save(Movement movement);

}
