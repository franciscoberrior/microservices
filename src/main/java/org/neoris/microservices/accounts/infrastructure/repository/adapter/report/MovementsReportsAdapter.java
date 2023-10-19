package org.neoris.microservices.accounts.infrastructure.repository.adapter.report;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.neoris.microservices.accounts.domain.entity.Movement;
import org.neoris.microservices.accounts.domain.service.report.MovementReportByDateService;
import org.neoris.microservices.accounts.infrastructure.repository.dto.movement.MovementRepository;
import org.neoris.microservices.accounts.infrastructure.repository.dto.movement.mapper.MovementDtoMapper;
import org.neoris.microservices.clients.infrastructure.repository.dto.client.ClientRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MovementsReportsAdapter implements MovementReportByDateService {

  private final MovementRepository movementRepository;
  private final MovementDtoMapper movementDtoMapper;
  private final ClientRepository clientRepository;

  @Override
  public List<Movement> findBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
    return movementDtoMapper.toEntity(movementRepository.findBetweenDates(startDate, endDate));
  }
}
