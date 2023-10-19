package org.neoris.microservices.accounts.infrastructure.event.listener.dto.mapper;

import org.mapstruct.Mapper;
import org.neoris.microservices.accounts.domain.entity.Client;
import org.neoris.microservices.accounts.infrastructure.event.listener.dto.ClientRequestDTO;
import org.neoris.microservices.shared.EntityMapper;

@Mapper
public interface AccountClientRequestDtoMapper extends EntityMapper<ClientRequestDTO, Client> {

}
