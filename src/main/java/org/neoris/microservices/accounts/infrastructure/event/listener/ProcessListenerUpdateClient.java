package org.neoris.microservices.accounts.infrastructure.event.listener;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.neoris.microservices.accounts.application.client.SaveClientService;
import org.neoris.microservices.accounts.application.client.UpdateClientService;
import org.neoris.microservices.accounts.infrastructure.event.listener.dto.ClientRequestDTO;
import org.neoris.microservices.accounts.infrastructure.event.listener.dto.mapper.AccountClientRequestDtoMapper;
import org.neoris.microservices.shared.event.EventProcessor;
import org.neoris.microservices.shared.event.dto.Event;
import org.neoris.microservices.shared.exception.infrastructure.event.UnreadableEventException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProcessListenerUpdateClient extends EventProcessor<ClientRequestDTO> {

  public static final String CREATE_CLIENT = "UPDATE_CLIENT";
  private final Gson gson;
  private final UpdateClientService updateClientService;
  private final AccountClientRequestDtoMapper accountClientRequestDtoMapper;


  protected ProcessListenerUpdateClient(Gson gson, UpdateClientService updateClientService,
      AccountClientRequestDtoMapper accountClientRequestDtoMapper) {
    super(CREATE_CLIENT);
    this.gson = gson;
    this.updateClientService = updateClientService;
    this.accountClientRequestDtoMapper = accountClientRequestDtoMapper;
  }

  @Override
  public void process(Event<ClientRequestDTO> messageEvent) {
    updateClientService.update(accountClientRequestDtoMapper.toEntity(messageEvent.getData()));
  }

  @Override
  public ClientRequestDTO readValue(String content) {
    try {
      return gson.fromJson(content, ClientRequestDTO.class);
    } catch (Exception e) {
      log.error("Se presento un error al convertir el json: [{}], \n Error: [{}::{}]",
          content, e.getClass(), e.getLocalizedMessage());
      throw new UnreadableEventException(e.getMessage());
    }

  }

}