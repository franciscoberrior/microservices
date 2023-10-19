package org.neoris.microservices.clients.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class Person {

  private String name;
  private String gender;
  private Integer age;
  private String documentId;
  private String address;
  private String phone;
}
