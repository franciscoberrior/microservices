package org.neoris.microservices.shared.event.dto;

import java.io.Serializable;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ErrorDetail implements Serializable {

  private String type;
  private String description;
  private String code;
}