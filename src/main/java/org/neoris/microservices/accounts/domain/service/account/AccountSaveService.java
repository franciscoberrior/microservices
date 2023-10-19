package org.neoris.microservices.accounts.domain.service.account;

import org.neoris.microservices.accounts.domain.entity.Account;

public interface AccountSaveService {

  void save(Account account);

}
