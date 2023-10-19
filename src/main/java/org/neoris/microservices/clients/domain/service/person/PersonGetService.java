package org.neoris.microservices.clients.domain.service.person;

import org.neoris.microservices.clients.domain.entity.Person;

public interface PersonGetService {

  Person getById(Long id);

}
