package org.neoris.microservices.shared.exception.handler.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

  private Integer status;
  private String code;
  private String message;
  private String date;
}