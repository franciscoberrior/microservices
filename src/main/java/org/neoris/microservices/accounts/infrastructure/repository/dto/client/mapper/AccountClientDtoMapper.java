package org.neoris.microservices.accounts.infrastructure.repository.dto.client.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.neoris.microservices.accounts.domain.entity.Client;
import org.neoris.microservices.accounts.infrastructure.repository.dto.client.ClientDTO;

@Mapper
public interface AccountClientDtoMapper {

  @BeanMapping(builder = @Builder(disableBuilder = true))
  @Mapping(target = "name", source = "clientId.name")
  @Mapping(target = "gender", source = "clientId.gender")
  @Mapping(target = "age", source = "clientId.age")
  @Mapping(target = "documentId", source = "clientId.documentId")
  @Mapping(target = "address", source = "clientId.address")
  @Mapping(target = "phone", source = "clientId.phone")
  Client toEntity(ClientDTO clientDTO);

  @Mapping(target = "clientId.name", source = "name")
  @Mapping(target = "clientId.gender", source = "gender")
  @Mapping(target = "clientId.age", source = "age")
  @Mapping(target = "clientId.documentId", source = "documentId")
  @Mapping(target = "clientId.address", source = "address")
  @Mapping(target = "clientId.phone", source = "phone")
  ClientDTO toDto(Client entity);

}
