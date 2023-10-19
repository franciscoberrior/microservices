package org.neoris.microservices.accounts.infrastructure.repository.dto.account;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neoris.microservices.accounts.domain.entity.enums.AccountTypeEnum;
import org.neoris.microservices.accounts.infrastructure.repository.dto.client.ClientDTO;

@Data
@Entity
@Table(name = "ACCOUNT")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDTO {

  @Id
  private String number;
  @Enumerated(EnumType.STRING)
  private AccountTypeEnum type;
  @Column(name = "initial_balance")
  private BigDecimal initialBalance;
  private Boolean status;
  @ManyToOne
  @JoinColumn(name = "client_id", referencedColumnName = "id")
  private ClientDTO clientId;
}
