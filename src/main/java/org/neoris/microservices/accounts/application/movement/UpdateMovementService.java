package org.neoris.microservices.accounts.application.movement;

import lombok.AllArgsConstructor;
import org.neoris.microservices.accounts.domain.entity.Movement;
import org.neoris.microservices.accounts.domain.service.movement.MovementUpdateService;

@AllArgsConstructor
public class UpdateMovementService {

  private final MovementUpdateService movementUpdateService;

  public void update(Movement movement) {
    movementUpdateService.update(movement);
  }

}
