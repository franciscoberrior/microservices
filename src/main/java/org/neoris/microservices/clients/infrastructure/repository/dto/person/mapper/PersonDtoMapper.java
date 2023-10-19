package org.neoris.microservices.clients.infrastructure.repository.dto.person.mapper;

import org.mapstruct.Mapper;
import org.neoris.microservices.clients.domain.entity.Person;
import org.neoris.microservices.clients.infrastructure.repository.dto.person.PersonDTO;
import org.neoris.microservices.shared.EntityMapper;

@Mapper
public interface PersonDtoMapper extends EntityMapper<PersonDTO, Person> {

}
