package org.neoris.microservices.shared.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MessagesEnum {

  INVALID_MOVEMENT("Saldo no disponible"),
  ACCOUNT_NOT_FOUND("La cuenta no existe"),
  CLIENT_NOT_FOUND("El cliente no existe"),
  PERSON_NOT_FOUND("La persona no existe"),
  PERSON_FOUND("La persona que intenta crear ya existe"),
  INVALID_TYPE_MOVEMENT("El tipo de movimiento no existe"),
  INVALID_VALUE_MOVEMENT("El valor enviado no es acorde al tipo de movimiento"),
  INVALID_DATE_VALUE("La fecha no tiene el formato correcto (YYYY-MM-DD)"),
  INVALID_DATE_BETWEEN_VALUE("El campo no tiene en el formato correcto (YYYY-MM-DD,YYYY-MM-DD)");

  private String message;
}
