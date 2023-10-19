package org.neoris.microservices.clients.infrastructure.repository.adapter.client;

import java.util.Optional;
import lombok.AllArgsConstructor;
import org.neoris.microservices.clients.domain.entity.Client;
import org.neoris.microservices.clients.domain.service.client.ClientDeleteService;
import org.neoris.microservices.clients.domain.service.client.ClientGetService;
import org.neoris.microservices.clients.domain.service.client.ClientSaveService;
import org.neoris.microservices.clients.domain.service.client.ClientUpdateService;
import org.neoris.microservices.clients.infrastructure.repository.dto.client.ClientDTO;
import org.neoris.microservices.clients.infrastructure.repository.dto.client.ClientRepository;
import org.neoris.microservices.clients.infrastructure.repository.dto.client.mapper.ClientDtoMapper;
import org.neoris.microservices.clients.infrastructure.repository.dto.person.PersonRepository;
import org.neoris.microservices.shared.exception.infrastructure.adapter.ClientNotFoundException;
import org.neoris.microservices.shared.exception.infrastructure.adapter.PersonFoundException;
import org.neoris.microservices.shared.exception.infrastructure.adapter.PersonNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientAdapter implements ClientSaveService, ClientGetService, ClientUpdateService,
    ClientDeleteService {

  private final ClientRepository clientRepository;
  private final ClientDtoMapper clientDtoMapper;
  private final PersonRepository personRepository;

  @Override
  public void delete(Long id) {
    clientRepository.deleteById(id);
  }

  @Override
  public Client getByDocumentId(String id) {
    return clientDtoMapper.toEntity(clientRepository.findByDocumentId(id).orElse(null));
  }

  @Override
  public Client save(Client client) {
    ClientDTO clientDTO = clientDtoMapper.toDto(client);
    if (personRepository.findById(client.getDocumentId()).isPresent()){
      throw new PersonFoundException();
    }
    personRepository.save(clientDTO.getClientId());
    return clientDtoMapper.toEntity(clientRepository.save(clientDTO));
  }

  @Override
  public Client update(Client client) {
    ClientDTO clientDTO = clientDtoMapper.toDto(client);
    if (personRepository.findById(clientDTO.getClientId().getDocumentId()).isPresent()) {
      Optional<ClientDTO> clientRes = clientRepository.findById(client.getId());
      if (clientRes.isPresent()) {
        personRepository.save(clientDTO.getClientId());
        clientDTO.setStatus(clientRes.get().getStatus());
        return clientDtoMapper.toEntity(clientRepository.save(clientDTO));
      } else {
        throw new ClientNotFoundException();
      }
    } else {
      throw new PersonNotFoundException();
    }
  }
}
