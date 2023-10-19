package org.neoris.microservices.accounts.infrastructure.repository.dto.movement;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neoris.microservices.accounts.domain.entity.enums.MovementTypeEnum;
import org.neoris.microservices.accounts.infrastructure.repository.dto.account.AccountDTO;

@Data
@Entity
@Table(name = "MOVEMENT")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovementDTO {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "date_movement")
  private LocalDateTime dateMovement;
  @Enumerated(EnumType.STRING)
  private MovementTypeEnum type;
  private BigDecimal value;
  private BigDecimal balance;
  @ManyToOne
  @JoinColumn(name = "account_number", referencedColumnName = "number")
  private AccountDTO accountNumber;

}
