package org.neoris.microservices.accounts.infrastructure.repository.adapter.client;

import java.util.Optional;
import lombok.AllArgsConstructor;
import org.neoris.microservices.accounts.domain.entity.Client;
import org.neoris.microservices.accounts.domain.service.client.ClientDeleteService;
import org.neoris.microservices.accounts.domain.service.client.ClientGetService;
import org.neoris.microservices.accounts.domain.service.client.ClientSaveService;
import org.neoris.microservices.accounts.domain.service.client.ClientUpdateService;
import org.neoris.microservices.accounts.infrastructure.repository.dto.client.AccountClientRepository;
import org.neoris.microservices.accounts.infrastructure.repository.dto.client.ClientDTO;
import org.neoris.microservices.accounts.infrastructure.repository.dto.client.mapper.AccountClientDtoMapper;
import org.neoris.microservices.accounts.infrastructure.repository.dto.person.AccountPersonRepository;
import org.neoris.microservices.accounts.infrastructure.repository.dto.person.PersonDTO;
import org.neoris.microservices.shared.exception.infrastructure.adapter.ClientNotFoundException;
import org.neoris.microservices.shared.exception.infrastructure.adapter.PersonFoundException;
import org.neoris.microservices.shared.exception.infrastructure.adapter.PersonNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountClientAdapter implements ClientSaveService, ClientGetService, ClientUpdateService,
    ClientDeleteService {

  private final AccountClientRepository accountClientRepository;
  private final AccountClientDtoMapper accountClientDtoMapper;
  private final AccountPersonRepository accountPersonRepository;

  @Override
  public void delete(Long id) {
    accountClientRepository.deleteById(id);
  }

  @Override
  public Client get(String id) {
    return accountClientDtoMapper.toEntity(accountClientRepository.findByDocumentId(id).orElse(null));
  }

  @Override
  public void save(Client client) {
    ClientDTO clientDTO = accountClientDtoMapper.toDto(client);
    if (accountPersonRepository.findById(client.getDocumentId()).isPresent()){
      throw new PersonFoundException();
    }
    PersonDTO personDTO = clientDTO.getClientId();
    accountPersonRepository.save(personDTO);
    accountClientRepository.save(clientDTO);
  }

  @Override
  public void update(Client client) {
    ClientDTO clientDTO = accountClientDtoMapper.toDto(client);
    if (accountPersonRepository.findById(client.getDocumentId()).isPresent()) {
      Optional<ClientDTO> clientRes = accountClientRepository.findById(client.getId());
      if (clientRes.isPresent()) {
        accountPersonRepository.save(clientDTO.getClientId());
        clientDTO.setStatus(clientRes.get().getStatus());
        accountClientRepository.save(clientDTO);
      } else {
        throw new ClientNotFoundException();
      }
    } else {
      throw new PersonNotFoundException();
    }
  }
}
