package org.neoris.microservices.accounts.infrastructure.api.dto.mapper;

import org.mapstruct.Mapper;
import org.neoris.microservices.accounts.domain.entity.Movement;
import org.neoris.microservices.accounts.infrastructure.api.dto.response.MovementResponseDTO;
import org.neoris.microservices.shared.EntityMapper;

@Mapper
public interface MovementResponseDtoMapper extends EntityMapper<MovementResponseDTO, Movement> {

}
