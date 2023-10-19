package org.neoris.microservices.shared.exception.infrastructure.event;

import org.neoris.microservices.shared.exception.base.BusinessException;
import org.neoris.microservices.shared.exception.base.ExceptionCode;
import org.springframework.http.HttpStatus;

public class UnreadableEventException extends BusinessException {

  private static final long serialVersionUID = 2820617043783719815L;

  public UnreadableEventException(String message) {
    super(ExceptionCode.MALFORMED_MESSAGE, message, HttpStatus.INTERNAL_SERVER_ERROR, false);
  }

}