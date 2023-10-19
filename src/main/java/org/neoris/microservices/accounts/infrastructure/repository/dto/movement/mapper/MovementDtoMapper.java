package org.neoris.microservices.accounts.infrastructure.repository.dto.movement.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.neoris.microservices.accounts.domain.entity.Movement;
import org.neoris.microservices.accounts.infrastructure.repository.dto.account.mapper.AccountDtoMapper;
import org.neoris.microservices.accounts.infrastructure.repository.dto.client.mapper.AccountClientDtoMapper;
import org.neoris.microservices.accounts.infrastructure.repository.dto.movement.MovementDTO;
import org.neoris.microservices.shared.EntityMapper;

@Mapper(uses = {AccountDtoMapper.class},
injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MovementDtoMapper extends EntityMapper<MovementDTO, Movement> {

}
