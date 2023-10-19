package org.neoris.microservices.accounts.infrastructure.api.dto.response;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovementResponseDTO {

  private String type;
  private BigDecimal value;
  private BigDecimal balance;
}
