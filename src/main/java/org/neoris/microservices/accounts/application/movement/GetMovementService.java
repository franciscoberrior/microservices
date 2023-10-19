package org.neoris.microservices.accounts.application.movement;

import lombok.AllArgsConstructor;
import org.neoris.microservices.accounts.domain.entity.Movement;
import org.neoris.microservices.accounts.domain.service.movement.MovementGetService;

@AllArgsConstructor
public class GetMovementService {

  private final MovementGetService movementGetService;

  public Movement getById(Long id) {
    return movementGetService.getById(id);
  }

  public Movement lastMovement(String accountNumber) {
    return movementGetService.lastMovement(accountNumber);
  }
}
