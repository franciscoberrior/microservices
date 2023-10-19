package org.neoris.microservices.clients.infrastructure.repository.dto.client;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientDTO, Long> {

  @Query(value = "SELECT C FROM ClientDTO C WHERE C.clientId.documentId = ?1 AND C.status = true ")
  Optional<ClientDTO> findByDocumentId(String documentId);
}
