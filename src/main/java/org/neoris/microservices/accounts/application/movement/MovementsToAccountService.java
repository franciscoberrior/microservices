package org.neoris.microservices.accounts.application.movement;

import java.util.List;
import lombok.AllArgsConstructor;
import org.neoris.microservices.accounts.application.movement.types.MovementProcessTypes;
import org.neoris.microservices.accounts.domain.entity.Movement;
import org.neoris.microservices.shared.common.MessagesEnum;
import org.neoris.microservices.shared.exception.domain.InvalidTypeMovementException;

@AllArgsConstructor
public class MovementsToAccountService {

  private final List<MovementProcessTypes> movementProcessTypes;

  public Movement movement(Movement movement) {
    return movementProcessTypes.stream().filter(mpt -> mpt.type().equals(movement.getType())).findFirst()
        .orElseThrow(
            () -> new InvalidTypeMovementException())
        .process(movement);
  }

}
