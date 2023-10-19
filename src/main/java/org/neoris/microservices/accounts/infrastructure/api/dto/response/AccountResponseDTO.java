package org.neoris.microservices.accounts.infrastructure.api.dto.response;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountResponseDTO {

  private String number;
  private String type;
  private BigDecimal initialBalance;
  private String status;
}
