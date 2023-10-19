package org.neoris.microservices.accounts.application.reports;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.neoris.microservices.accounts.domain.entity.Movement;
import org.neoris.microservices.accounts.domain.service.report.MovementReportByDateService;
import org.neoris.microservices.shared.common.MessagesEnum;
import org.neoris.microservices.shared.exception.domain.InvalidDateReportException;
import org.neoris.microservices.shared.exception.domain.InvalidValueBetweenDateReportException;

@AllArgsConstructor
public class MovementReportByDate {

  private final MovementReportByDateService movementReportByDateService;

  public List<Movement> findBetweenDates(String dates) {
    String[] datesSplit = dates.split(",");
    if (datesSplit.length == 2) {
      LocalDateTime startDate = LocalDateTime.of(toLocalDate(datesSplit[0]),
          LocalTime.of(0, 0, 0));
      LocalDateTime endDate = LocalDateTime.of(toLocalDate(datesSplit[1]),
          LocalTime.of(23, 59, 59));
      return movementReportByDateService.findBetweenDates(startDate, endDate);
    } else {
      throw new InvalidValueBetweenDateReportException();
    }
  }

  private LocalDate toLocalDate(String date) {
    try {
      return LocalDate.parse(date);
    } catch (Exception e) {
      throw new InvalidDateReportException();
    }
  }

}
