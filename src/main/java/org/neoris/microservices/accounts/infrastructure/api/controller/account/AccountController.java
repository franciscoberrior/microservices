package org.neoris.microservices.accounts.infrastructure.api.controller.account;

import lombok.AllArgsConstructor;
import org.neoris.microservices.accounts.application.account.DeleteAccountService;
import org.neoris.microservices.accounts.application.account.GetAccountService;
import org.neoris.microservices.accounts.application.account.SaveAccountService;
import org.neoris.microservices.accounts.application.account.UpdateAccountService;
import org.neoris.microservices.accounts.infrastructure.api.dto.mapper.AccountRequestDtoMapper;
import org.neoris.microservices.accounts.infrastructure.api.dto.mapper.AccountResponseDtoMapper;
import org.neoris.microservices.accounts.infrastructure.api.dto.request.AccountRequestDTO;
import org.neoris.microservices.accounts.infrastructure.api.dto.response.AccountResponseDTO;
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
@RequestMapping("/cuentas")
public class AccountController {

  private final SaveAccountService saveAccountService;
  private final GetAccountService getAccountService;
  private final UpdateAccountService updateAccountService;
  private final DeleteAccountService deleteAccountService;
  private final AccountRequestDtoMapper accountRequestDtoMapper;
  private final AccountResponseDtoMapper accountResponseDtoMapper;

  @PostMapping
  public ResponseEntity save(@RequestBody AccountRequestDTO accountRequest) {
    saveAccountService.save(accountRequestDtoMapper.toEntity(accountRequest),
        accountRequest.getDocumentId());
    return ResponseEntity.ok().build();
  }

  @PutMapping
  public ResponseEntity update(@RequestBody AccountRequestDTO accountRequest) {
    updateAccountService.update(accountRequestDtoMapper.toEntity(accountRequest));
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<AccountResponseDTO> searchById(@RequestParam("accountId") String accoundId) {
    return ResponseEntity.ok(accountResponseDtoMapper.toDto(getAccountService.getById(accoundId)));
  }

  @DeleteMapping
  public ResponseEntity deleteById(@RequestParam("accountId") String accoundId) {
    deleteAccountService.delete(accoundId);
    return ResponseEntity.ok().build();
  }
}
