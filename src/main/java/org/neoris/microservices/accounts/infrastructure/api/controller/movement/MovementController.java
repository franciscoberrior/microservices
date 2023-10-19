package org.neoris.microservices.accounts.infrastructure.api.controller.movement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neoris.microservices.accounts.application.movement.DeleteMovementService;
import org.neoris.microservices.accounts.application.movement.GetMovementService;
import org.neoris.microservices.accounts.application.movement.SaveMovementService;
import org.neoris.microservices.accounts.application.movement.UpdateMovementService;
import org.neoris.microservices.accounts.infrastructure.api.dto.mapper.MovementRequestDtoMapper;
import org.neoris.microservices.accounts.infrastructure.api.dto.mapper.MovementResponseDtoMapper;
import org.neoris.microservices.accounts.infrastructure.api.dto.request.MovementRequestDTO;
import org.neoris.microservices.accounts.infrastructure.api.dto.response.MovementResponseDTO;
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
@RequestMapping("/movimientos")
public class MovementController {

  private final SaveMovementService saveMovementService;
  private final GetMovementService getMovementService;
  private final UpdateMovementService updateMovementService;
  private final DeleteMovementService deleteMovementService;
  private final MovementRequestDtoMapper movementRequestDtoMapper;
  private final MovementResponseDtoMapper movementResponseDtoMapper;

  @PostMapping
  public ResponseEntity save(@RequestBody MovementRequestDTO movementRequest) {
    saveMovementService.save(movementRequestDtoMapper.toEntity(movementRequest));
    return ResponseEntity.ok().build();
  }

  @PutMapping
  public ResponseEntity update(@RequestBody MovementRequestDTO movementRequest) {
    updateMovementService.update(movementRequestDtoMapper.toEntity(movementRequest));
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<MovementResponseDTO> searchById(@RequestParam("movementId") Long movementId) {
    return ResponseEntity.ok(movementResponseDtoMapper.toDto(getMovementService.getById(movementId)));
  }

  @DeleteMapping
  public ResponseEntity deleteById(@RequestParam("movementId") Long movementId) {
    deleteMovementService.delete(movementId);
    return ResponseEntity.ok().build();
  }
}
