package org.neoris.microservices.clients.infrastructure.api.controller.client;

import lombok.AllArgsConstructor;
import org.neoris.microservices.clients.application.client.DeleteClientService;
import org.neoris.microservices.clients.application.client.GetClientService;
import org.neoris.microservices.clients.application.client.SaveClientService;
import org.neoris.microservices.clients.application.client.UpdateClientService;
import org.neoris.microservices.clients.infrastructure.api.dto.mapper.ClientRequestDtoMapper;
import org.neoris.microservices.clients.infrastructure.api.dto.mapper.ClientResponseDtoMapper;
import org.neoris.microservices.clients.infrastructure.api.dto.mapper.ClientUpdateRequestDtoMapper;
import org.neoris.microservices.clients.infrastructure.api.dto.request.ClientRequestDTO;
import org.neoris.microservices.clients.infrastructure.api.dto.request.ClientUpdateRequestDto;
import org.neoris.microservices.clients.infrastructure.api.dto.response.ClientResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClientController {

  private final SaveClientService saveClientService;
  private final GetClientService getClientService;
  private final UpdateClientService updateClientService;
  private final DeleteClientService deleteClientService;
  private final ClientRequestDtoMapper clientRequestDtoMapper;
  private final ClientResponseDtoMapper clientResponseDtoMapper;
  private final ClientUpdateRequestDtoMapper clientUpdateRequestDtoMapper;

  @PostMapping
  public ResponseEntity<ClientResponseDTO> save(@RequestBody ClientRequestDTO clientRequestDTO) {
    return ResponseEntity.ok(clientResponseDtoMapper.toDto(
            saveClientService.save(clientRequestDtoMapper.toEntity(clientRequestDTO))));
  }

  @PutMapping
  public ResponseEntity update(@RequestBody ClientUpdateRequestDto clientRequestDTO) {
    updateClientService.update(clientUpdateRequestDtoMapper.toEntity(clientRequestDTO));
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<ClientResponseDTO> searchById(@RequestParam("clientId") String clientId) {
    return ResponseEntity.ok(clientResponseDtoMapper.toDto(getClientService.getById(clientId)));
  }

  @DeleteMapping
  public ResponseEntity deleteById(@RequestParam("clientId") String clientId) {
    deleteClientService.delete(clientId);
    return ResponseEntity.ok().build();
  }
}
