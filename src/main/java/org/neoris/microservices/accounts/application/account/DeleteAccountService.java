package org.neoris.microservices.accounts.application.account;

import lombok.AllArgsConstructor;
import org.neoris.microservices.accounts.domain.service.account.AccountDeleteService;

@AllArgsConstructor
public class DeleteAccountService {

  private final AccountDeleteService accountDeleteService;

  public void delete(String id) {
    accountDeleteService.deleteById(id);
  }

}
