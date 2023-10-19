package org.neoris.microservices.clients.infrastructure.api.dto.mapper;

import org.mapstruct.Mapper;
import org.neoris.microservices.clients.domain.entity.Client;
import org.neoris.microservices.clients.infrastructure.api.dto.response.ClientResponseDTO;
import org.neoris.microservices.shared.EntityMapper;

@Mapper
public interface ClientResponseDtoMapper extends EntityMapper<ClientResponseDTO, Client> {

}
