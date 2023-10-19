package org.neoris.microservices.shared.exception.base;

import org.springframework.http.HttpStatus;

public abstract class BusinessException extends BaseException {

  private static final long serialVersionUID = -91608591544709L;

  protected BusinessException(ExceptionCode exceptionCode, String message,
      HttpStatus status,boolean retryable) {
    super(retryable, status, message, exceptionCode);
  }

}
