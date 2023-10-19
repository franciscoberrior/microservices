package org.neoris.microservices.accounts.infrastructure.api.dto.request;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neoris.microservices.accounts.domain.entity.enums.AccountTypeEnum;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountRequestDTO {

  private String number;
  private AccountTypeEnum type;
  private BigDecimal initialBalance;
  private String documentId;

}
