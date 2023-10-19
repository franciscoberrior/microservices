package org.neoris.microservices.accounts.infrastructure.repository.dto.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountPersonRepository extends JpaRepository<PersonDTO, String> {

}
