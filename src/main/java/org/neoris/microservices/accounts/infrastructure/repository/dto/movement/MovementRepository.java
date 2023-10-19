package org.neoris.microservices.accounts.infrastructure.repository.dto.movement;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<MovementDTO, Long> {

  @Query(value = "SELECT M "
      + "FROM MovementDTO M WHERE M.accountNumber.number = ?1 "
      + " AND dateMovement = ("
      + "SELECT MAX(MO.dateMovement) FROM MovementDTO MO WHERE "
      + "M.accountNumber.number = ?1 "
      + "GROUP BY M.accountNumber.number"
      + ")")
  Optional<MovementDTO> findLastMovement(String accountNumber);

  @Query("SELECT M FROM MovementDTO M WHERE M.dateMovement between ?1 AND ?2")
  List<MovementDTO> findBetweenDates(LocalDateTime startDate, LocalDateTime endDate);

}
