package org.neoris.microservices.accounts.infrastructure.repository.adapter.movement;

import lombok.AllArgsConstructor;
import org.neoris.microservices.accounts.domain.entity.Movement;
import org.neoris.microservices.accounts.domain.service.movement.MovementDeleteService;
import org.neoris.microservices.accounts.domain.service.movement.MovementGetService;
import org.neoris.microservices.accounts.domain.service.movement.MovementSaveService;
import org.neoris.microservices.accounts.domain.service.movement.MovementUpdateService;
import org.neoris.microservices.accounts.infrastructure.repository.dto.movement.MovementRepository;
import org.neoris.microservices.accounts.infrastructure.repository.dto.movement.mapper.MovementDtoMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MovementAdapter implements MovementSaveService, MovementGetService,
    MovementUpdateService, MovementDeleteService {

  private final MovementRepository movementRepository;
  private final MovementDtoMapper movementDtoMapper;

  @Override
  public void deleteById(Long id) {
    movementRepository.deleteById(id);
  }

  @Override
  public Movement getById(Long id) {
    return movementDtoMapper.toEntity(movementRepository.findById(id).orElse(null));
  }

  @Override
  public Movement lastMovement(String accountNumber) {
    return movementDtoMapper.toEntity(movementRepository.findLastMovement(accountNumber).orElse(null));
  }

  @Override
  public Movement save(Movement movement) {
    return movementDtoMapper.toEntity(movementRepository.save(movementDtoMapper.toDto(movement)));
  }

  @Override
  public void update(Movement movement) {
    movementRepository.findById(movement.getId())
        .ifPresent(mv -> movementRepository.save(movementDtoMapper.toDto(movement)));
  }
}
