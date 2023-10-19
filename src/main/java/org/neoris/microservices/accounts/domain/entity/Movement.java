package org.neoris.microservices.accounts.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import org.neoris.microservices.accounts.domain.entity.enums.MovementTypeEnum;

@Data
@Builder
public class Movement {

  private Long id;
  private LocalDateTime dateMovement;
  private MovementTypeEnum type;
  private BigDecimal value;
  private BigDecimal balance;
  private Account accountNumber;
}
