package org.neoris.microservices.accounts.application.account;

import lombok.AllArgsConstructor;
import org.neoris.microservices.accounts.domain.entity.Account;
import org.neoris.microservices.accounts.domain.service.account.AccountGetService;

@AllArgsConstructor
public class GetAccountService {

  private final AccountGetService accountGetService;

  public Account getById(String id) {
    return accountGetService.getById(id);
  }
}
