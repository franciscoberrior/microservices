package org.neoris.microservices.shared.exception.infrastructure.event;


import org.neoris.microservices.shared.exception.base.BusinessException;
import org.neoris.microservices.shared.exception.base.ExceptionCode;
import org.springframework.http.HttpStatus;

public class InvalidEventException extends BusinessException {

  private static final long serialVersionUID = 2820617043783719815L;

  public InvalidEventException(String message) {
    super(ExceptionCode.TECHNICAL, message, HttpStatus.INTERNAL_SERVER_ERROR, false);
  }

}