package org.neoris.microservices.accounts.infrastructure.event.listener.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDTO {

  private Long id;
  private String name;
  private String gender;
  private Integer age;
  private String documentId;
  private String address;
  private String phone;
  private String password;
  private Boolean status;
}