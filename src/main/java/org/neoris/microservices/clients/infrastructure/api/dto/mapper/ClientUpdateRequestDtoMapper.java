package org.neoris.microservices.clients.infrastructure.api.dto.mapper;

import org.mapstruct.Mapper;
import org.neoris.microservices.clients.domain.entity.Client;
import org.neoris.microservices.clients.infrastructure.api.dto.request.ClientRequestDTO;
import org.neoris.microservices.clients.infrastructure.api.dto.request.ClientUpdateRequestDto;
import org.neoris.microservices.shared.EntityMapper;

@Mapper
public interface ClientUpdateRequestDtoMapper extends EntityMapper<ClientUpdateRequestDto, Client> {

}
