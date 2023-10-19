package org.neoris.microservices.clients.infrastructure.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientUpdateRequestDto {

  private Long id;
  private String name;
  private String gender;
  private Integer age;
  private String documentId;
  private String address;
  private String phone;
  private String password;
}
