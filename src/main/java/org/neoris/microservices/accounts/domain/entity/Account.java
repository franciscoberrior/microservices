package org.neoris.microservices.accounts.domain.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;
import org.neoris.microservices.accounts.domain.entity.enums.AccountTypeEnum;

@Data
@Builder
public class Account {

  private String number;
  private AccountTypeEnum type;
  private BigDecimal initialBalance;
  private Boolean status;
  private Client clientId;
}
