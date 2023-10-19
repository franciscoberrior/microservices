package org.neoris.microservices.accounts.infrastructure.api.dto.mapper;

import org.mapstruct.Mapper;
import org.neoris.microservices.accounts.domain.entity.Account;
import org.neoris.microservices.accounts.infrastructure.api.dto.request.AccountRequestDTO;
import org.neoris.microservices.shared.EntityMapper;

@Mapper
public interface AccountRequestDtoMapper extends EntityMapper<AccountRequestDTO, Account> {

}
