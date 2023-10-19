package org.neoris.microservices.accounts.application;

import java.util.List;
import org.neoris.microservices.accounts.application.account.DeleteAccountService;
import org.neoris.microservices.accounts.application.account.GetAccountService;
import org.neoris.microservices.accounts.application.account.SaveAccountService;
import org.neoris.microservices.accounts.application.account.UpdateAccountService;
import org.neoris.microservices.accounts.application.client.DeleteClientService;
import org.neoris.microservices.accounts.application.client.GetClientService;
import org.neoris.microservices.accounts.application.client.SaveClientService;
import org.neoris.microservices.accounts.application.client.UpdateClientService;
import org.neoris.microservices.accounts.application.movement.DeleteMovementService;
import org.neoris.microservices.accounts.application.movement.GetMovementService;
import org.neoris.microservices.accounts.application.movement.MovementsToAccountService;
import org.neoris.microservices.accounts.application.movement.SaveMovementService;
import org.neoris.microservices.accounts.application.movement.UpdateMovementService;
import org.neoris.microservices.accounts.application.movement.types.DepositMovements;
import org.neoris.microservices.accounts.application.movement.types.MovementProcessTypes;
import org.neoris.microservices.accounts.application.movement.types.WithdrawalMovements;
import org.neoris.microservices.accounts.application.reports.MovementReportByDate;
import org.neoris.microservices.accounts.domain.service.account.AccountDeleteService;
import org.neoris.microservices.accounts.domain.service.account.AccountGetService;
import org.neoris.microservices.accounts.domain.service.account.AccountSaveService;
import org.neoris.microservices.accounts.domain.service.account.AccountUpdateService;
import org.neoris.microservices.accounts.domain.service.client.ClientDeleteService;
import org.neoris.microservices.accounts.domain.service.client.ClientGetService;
import org.neoris.microservices.accounts.domain.service.client.ClientSaveService;
import org.neoris.microservices.accounts.domain.service.client.ClientUpdateService;
import org.neoris.microservices.accounts.domain.service.movement.MovementDeleteService;
import org.neoris.microservices.accounts.domain.service.movement.MovementGetService;
import org.neoris.microservices.accounts.domain.service.movement.MovementSaveService;
import org.neoris.microservices.accounts.domain.service.movement.MovementUpdateService;
import org.neoris.microservices.accounts.domain.service.report.MovementReportByDateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigAccountServices {

  @Bean
  public DeleteAccountService deleteAccountService(AccountDeleteService accountDeleteService) {
    return new DeleteAccountService(accountDeleteService);
  }

  @Bean
  public GetAccountService getAccountService(AccountGetService accountGetService) {
    return new GetAccountService(accountGetService);
  }

  @Bean
  public SaveAccountService saveAccountService(AccountSaveService accountSaveService,
      GetClientService getAccountClientService) {
    return new SaveAccountService(accountSaveService, getAccountClientService);
  }

  @Bean
  public UpdateAccountService updateAccountService(AccountUpdateService accountUpdateService) {
    return new UpdateAccountService(accountUpdateService);
  }


  @Bean
  public DeleteMovementService deleteMovementService(MovementDeleteService accountUpdateService) {
    return new DeleteMovementService(accountUpdateService);
  }

  @Bean
  public GetMovementService getMovementService(MovementGetService movementGetService) {
    return new GetMovementService(movementGetService);
  }

  @Bean
  public SaveMovementService saveMovementService(MovementSaveService movementGetService,
      MovementsToAccountService movementsToAccountService) {
    return new SaveMovementService(movementGetService, movementsToAccountService);
  }

  @Bean
  public UpdateMovementService updateMovementService(MovementUpdateService movementUpdateService) {
    return new UpdateMovementService(movementUpdateService);
  }

  @Bean
  public DeleteClientService deleteClientServiceAccount(ClientDeleteService clientDeleteService) {
    return new DeleteClientService(clientDeleteService);
  }

  @Bean
  public GetClientService getClientServiceAccount(ClientGetService clientGetService) {
    return new GetClientService(clientGetService);
  }

  @Bean
  public SaveClientService saveClientServiceAccount(ClientSaveService clientSaveService) {
    return new SaveClientService(clientSaveService);
  }

  @Bean
  public UpdateClientService updateClientServiceAccount(ClientUpdateService clientUpdateService) {
    return new UpdateClientService(clientUpdateService);
  }

  @Bean
  public DepositMovements depositMovements(GetAccountService getAccountService,
      GetMovementService getMovementService) {
    return new DepositMovements(getAccountService, getMovementService);
  }

  @Bean
  public WithdrawalMovements withdrawalMovements(GetAccountService getAccountService,
      GetMovementService getMovementService) {
    return new WithdrawalMovements(getAccountService, getMovementService);
  }

  @Bean
  public List<MovementProcessTypes> movementProcessTypes(DepositMovements depositMovements,
      WithdrawalMovements withdrawalMovements) {
    return List.of(depositMovements, withdrawalMovements);
  }

  @Bean
  public MovementsToAccountService movementsToAccountService(
      List<MovementProcessTypes> movementProcessTypes) {
    return new MovementsToAccountService(movementProcessTypes);
  }

  @Bean
  public MovementReportByDate movementReportByDate(
      MovementReportByDateService movementReportByDateService) {
    return new MovementReportByDate(movementReportByDateService);
  }
}
