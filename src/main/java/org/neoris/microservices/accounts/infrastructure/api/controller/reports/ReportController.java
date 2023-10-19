package org.neoris.microservices.accounts.infrastructure.api.controller.reports;

import java.util.List;
import lombok.AllArgsConstructor;
import org.neoris.microservices.accounts.application.reports.MovementReportByDate;
import org.neoris.microservices.accounts.infrastructure.api.dto.mapper.MovementByDatesResponseDtoMapper;
import org.neoris.microservices.accounts.infrastructure.api.dto.response.MovementByDatesDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/reportes")
public class ReportController {

  private final MovementReportByDate movementReportByDate;
  private final MovementByDatesResponseDtoMapper movementByDatesResponseDtoMapper;

  @GetMapping
  public ResponseEntity<List<MovementByDatesDto>> searchMovementsBetweenDates(
      @RequestParam("fecha") String dates) {
    return ResponseEntity.ok(
        movementByDatesResponseDtoMapper.toDto(movementReportByDate.findBetweenDates(dates)));
  }
}
