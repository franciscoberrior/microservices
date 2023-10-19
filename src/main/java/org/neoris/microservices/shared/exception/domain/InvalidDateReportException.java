package org.neoris.microservices.shared.exception.domain;


import org.neoris.microservices.shared.common.MessagesEnum;
import org.neoris.microservices.shared.exception.base.BusinessException;
import org.neoris.microservices.shared.exception.base.ExceptionCode;
import org.springframework.http.HttpStatus;

public class InvalidDateReportException extends BusinessException {

  private static final long serialVersionUID = 2820617043783719815L;

  public InvalidDateReportException() {
    super(ExceptionCode.BUSINESS, MessagesEnum.INVALID_VALUE_MOVEMENT.getMessage(), HttpStatus.BAD_REQUEST, false);
  }

}