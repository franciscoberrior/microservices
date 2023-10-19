package org.neoris.microservices.accounts.infrastructure.api.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovementByDatesDto {

  private LocalDateTime date;
  private String clientName;
  private String accountNumber;
  private String type;
  private BigDecimal initialBalance;
  private String status;
  private BigDecimal movement;
  private BigDecimal availableBalance;

}
