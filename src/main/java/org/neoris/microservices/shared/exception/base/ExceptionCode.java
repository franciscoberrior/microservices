package org.neoris.microservices.shared.exception.base;

public enum ExceptionCode {
  BUSINESS("NEORIS-BUSSINESS-001", "EXCEPCION_NEGOCIO"),
  MALFORMED_MESSAGE("NEORIS-EVT-001", "MALFORMED_MESSAGE_RECEIVED"),
  TECHNICAL("NEORIS-TCH-001", "EXCEPCION_TECNICA");

  private final String code;
  private final String type;

  ExceptionCode(String code, String type) {
    this.code = code;
    this.type = type;
  }

  public String getCode() {
    return code;
  }

  public String getType() {
    return type;
  }

}