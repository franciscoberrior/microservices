package org.neoris.microservices.accounts.domain.service.movement;

import org.neoris.microservices.accounts.domain.entity.Movement;

public interface MovementGetService {

  Movement getById(Long id);

  Movement lastMovement(String accountNumber);

}
