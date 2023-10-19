package org.neoris.microservices.accounts.infrastructure.repository.dto.account.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.neoris.microservices.accounts.domain.entity.Account;
import org.neoris.microservices.accounts.infrastructure.repository.dto.account.AccountDTO;
import org.neoris.microservices.accounts.infrastructure.repository.dto.client.mapper.AccountClientDtoMapper;
import org.neoris.microservices.shared.EntityMapper;

@Mapper(uses = {AccountClientDtoMapper.class},
injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountDtoMapper extends EntityMapper<AccountDTO, Account> {

}
