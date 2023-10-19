package org.neoris.microservices.accounts.domain.service.report;

import java.time.LocalDateTime;
import java.util.List;
import org.neoris.microservices.accounts.domain.entity.Movement;

public interface MovementReportByDateService {

  List<Movement> findBetweenDates(LocalDateTime startDate, LocalDateTime endDate);

}
