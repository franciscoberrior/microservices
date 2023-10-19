package org.neoris.microservices.clients.infrastructure.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDTO {

  private Long id;
  private String password;
  private Boolean status;
  private String name;
  private String gender;
  private Integer age;
  private String documentId;
  private String address;
  private String phone;

}
