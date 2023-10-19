package org.neoris.microservices.accounts.infrastructure.event.listener;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.neoris.microservices.accounts.application.client.DeleteClientService;
import org.neoris.microservices.accounts.application.client.SaveClientService;
import org.neoris.microservices.accounts.infrastructure.event.listener.dto.ClientRequestDTO;
import org.neoris.microservices.accounts.infrastructure.event.listener.dto.mapper.AccountClientRequestDtoMapper;
import org.neoris.microservices.shared.event.EventProcessor;
import org.neoris.microservices.shared.event.dto.Event;
import org.neoris.microservices.shared.exception.infrastructure.event.UnreadableEventException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProcessListenerDeleteClient extends EventProcessor<ClientRequestDTO> {

  public static final String CREATE_CLIENT = "DELETE_CLIENT";
  private final Gson gson;
  private final DeleteClientService deleteClientService;


  protected ProcessListenerDeleteClient(Gson gson, DeleteClientService deleteClientService,
      AccountClientRequestDtoMapper accountClientRequestDtoMapper) {
    super(CREATE_CLIENT);
    this.gson = gson;
    this.deleteClientService = deleteClientService;
  }

  @Override
  public void process(Event<ClientRequestDTO> messageEvent) {
    deleteClientService.delete(messageEvent.getData().getId());
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