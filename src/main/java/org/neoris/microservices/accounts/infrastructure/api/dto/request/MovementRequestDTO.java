package org.neoris.microservices.accounts.infrastructure.api.dto.request;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neoris.microservices.accounts.domain.entity.enums.MovementTypeEnum;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovementRequestDTO {

  private MovementTypeEnum type;
  private BigDecimal value;
  private String accountNumber;

}
