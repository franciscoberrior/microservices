package org.neoris.microservices.accounts.application.movement.types;

import org.neoris.microservices.accounts.domain.entity.Movement;
import org.neoris.microservices.accounts.domain.entity.enums.MovementTypeEnum;

public interface MovementProcessTypes {

  MovementTypeEnum type();

  Movement process(Movement movement);

}
