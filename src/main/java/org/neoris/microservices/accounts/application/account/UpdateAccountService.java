package org.neoris.microservices.accounts.application.account;

import lombok.AllArgsConstructor;
import org.neoris.microservices.accounts.domain.entity.Account;
import org.neoris.microservices.accounts.domain.service.account.AccountUpdateService;

@AllArgsConstructor
public class UpdateAccountService {

  private final AccountUpdateService accountUpdateService;

  public void update(Account account) {
    accountUpdateService.update(account);
  }

}
