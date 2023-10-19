package org.neoris.microservices.shared.exception.infrastructure.adapter;


import org.neoris.microservices.shared.common.MessagesEnum;
import org.neoris.microservices.shared.exception.base.BusinessException;
import org.neoris.microservices.shared.exception.base.ExceptionCode;
import org.springframework.http.HttpStatus;

public class ClientNotFoundException extends BusinessException {

  private static final long serialVersionUID = 2820617043783719815L;

  public ClientNotFoundException() {
    super(ExceptionCode.BUSINESS, MessagesEnum.CLIENT_NOT_FOUND.getMessage(), HttpStatus.NOT_FOUND, false);
  }

}