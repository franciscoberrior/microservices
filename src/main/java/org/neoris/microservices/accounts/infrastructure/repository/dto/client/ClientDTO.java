package org.neoris.microservices.accounts.infrastructure.repository.dto.client;

import javax.persistence.Entity;
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
import org.hibernate.annotations.SQLDelete;
import org.neoris.microservices.accounts.infrastructure.repository.dto.person.PersonDTO;

@Data
@Entity
@Table(name = "CLIENT")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLDelete(sql = "UPDATE CLIENT SET status = false WHERE id = ?")
public class ClientDTO {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "client_id", referencedColumnName = "document_id")
  private PersonDTO clientId;
  private String password;
  private Boolean status;
}
