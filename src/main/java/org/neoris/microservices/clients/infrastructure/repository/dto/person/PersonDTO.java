package org.neoris.microservices.clients.infrastructure.repository.dto.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "PERSON")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDTO {

  @Id
  @Column(name = "document_id")
  private String documentId;
  private String name;
  private String gender;
  private Integer age;
  private String address;
  private String phone;
}
