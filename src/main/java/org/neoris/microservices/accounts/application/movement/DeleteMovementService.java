package org.neoris.microservices.accounts.application.movement;

import lombok.AllArgsConstructor;
import org.neoris.microservices.accounts.domain.service.movement.MovementDeleteService;

@AllArgsConstructor
public class DeleteMovementService {

  private final MovementDeleteService movementDeleteService;

  public void delete(Long id) {
    movementDeleteService.deleteById(id);
  }

}
