package org.neoris.microservices.accounts.application.movement;

import lombok.AllArgsConstructor;
import org.neoris.microservices.accounts.application.account.GetAccountService;
import org.neoris.microservices.accounts.application.account.UpdateAccountService;
import org.neoris.microservices.accounts.domain.entity.Movement;
import org.neoris.microservices.accounts.domain.service.movement.MovementSaveService;

@AllArgsConstructor
public class SaveMovementService {

  private final MovementSaveService movementSaveService;
  private final MovementsToAccountService movementsToAccountService;

  public Movement save(Movement movement) {
    movement = movementsToAccountService.movement(movement);
    return movementSaveService.save(movement);
  }

}
