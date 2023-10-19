package org.neoris.microservices.accounts.infrastructure.api.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.neoris.microservices.accounts.domain.entity.Movement;
import org.neoris.microservices.accounts.infrastructure.api.dto.request.MovementRequestDTO;
import org.neoris.microservices.shared.EntityMapper;

@Mapper
public interface MovementRequestDtoMapper {

  @Mapping(source = "accountNumber", target = "accountNumber.number")
  Movement toEntity(MovementRequestDTO dto);

  @Mapping(target = "accountNumber", source = "accountNumber.number")
  MovementRequestDTO toDto(Movement entity);

}
