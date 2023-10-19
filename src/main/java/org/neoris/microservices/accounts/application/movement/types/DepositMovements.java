package org.neoris.microservices.accounts.application.movement.types;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.neoris.microservices.accounts.application.account.GetAccountService;
import org.neoris.microservices.accounts.application.account.UpdateAccountService;
import org.neoris.microservices.accounts.application.movement.GetMovementService;
import org.neoris.microservices.accounts.domain.entity.Account;
import org.neoris.microservices.accounts.domain.entity.Movement;
import org.neoris.microservices.accounts.domain.entity.enums.MovementTypeEnum;
import org.neoris.microservices.shared.common.MessagesEnum;
import org.neoris.microservices.shared.exception.domain.InvalidMovementException;
import org.neoris.microservices.shared.exception.domain.InvalidValueMovementException;

@AllArgsConstructor
public class DepositMovements implements MovementProcessTypes{

  private final GetAccountService getAccountService;
  private final GetMovementService getMovementService;

  @Override
  public MovementTypeEnum type() {
    return MovementTypeEnum.DEPOSITO;
  }

  @Override
  public Movement process(Movement movement) {
    isPositiveValue(movement.getValue());
    Account account = getAccountService.getById(movement.getAccountNumber().getNumber());
    Movement movementFinded = getMovementService.lastMovement(account.getNumber());
    BigDecimal calculatedValue;
    if (Objects.nonNull(movementFinded)){
      calculatedValue = movementFinded.getBalance().plus().add(movement.getValue());
    } else {
      calculatedValue = account.getInitialBalance().plus().add(movement.getValue());
    }
    movement.setDateMovement(LocalDateTime.now());
    movement.setBalance(calculatedValue);
    return movement;
  }

  private void isPositiveValue(BigDecimal value){
    if (value.signum() != 1){
      throw new InvalidValueMovementException();
    }
  }


}
