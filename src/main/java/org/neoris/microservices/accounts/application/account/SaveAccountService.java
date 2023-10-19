package org.neoris.microservices.accounts.application.account;

import lombok.AllArgsConstructor;
import org.neoris.microservices.accounts.application.client.GetClientService;
import org.neoris.microservices.accounts.domain.entity.Account;
import org.neoris.microservices.accounts.domain.service.account.AccountSaveService;

@AllArgsConstructor
public class SaveAccountService {

  private final AccountSaveService accountSaveService;
  private final GetClientService getClientService;

  public void save(Account account, String documentId) {
    account.setStatus(true);
    account.setClientId(getClientService.getById(documentId));
    accountSaveService.save(account);
  }

}
