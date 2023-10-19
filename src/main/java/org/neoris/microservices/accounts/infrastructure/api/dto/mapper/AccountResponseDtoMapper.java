package org.neoris.microservices.accounts.infrastructure.api.dto.mapper;

import org.mapstruct.Mapper;
import org.neoris.microservices.accounts.domain.entity.Account;
import org.neoris.microservices.accounts.infrastructure.api.dto.response.AccountResponseDTO;
import org.neoris.microservices.shared.EntityMapper;

@Mapper
public interface AccountResponseDtoMapper extends EntityMapper<AccountResponseDTO, Account> {

}
