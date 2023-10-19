package org.neoris.microservices.clients.infrastructure.api.controller.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.neoris.microservices.clients.application.client.DeleteClientService;
import org.neoris.microservices.clients.application.client.GetClientService;
import org.neoris.microservices.clients.application.client.SaveClientService;
import org.neoris.microservices.clients.application.client.UpdateClientService;
import org.neoris.microservices.clients.domain.entity.Client;
import org.neoris.microservices.clients.domain.service.client.ClientDeleteService;
import org.neoris.microservices.clients.domain.service.client.ClientGetService;
import org.neoris.microservices.clients.domain.service.client.ClientSaveService;
import org.neoris.microservices.clients.domain.service.client.ClientUpdateService;
import org.neoris.microservices.clients.infrastructure.api.dto.mapper.ClientRequestDtoMapper;
import org.neoris.microservices.clients.infrastructure.api.dto.mapper.ClientRequestDtoMapperImpl;
import org.neoris.microservices.clients.infrastructure.api.dto.mapper.ClientResponseDtoMapper;
import org.neoris.microservices.clients.infrastructure.api.dto.mapper.ClientResponseDtoMapperImpl;
import org.neoris.microservices.clients.infrastructure.api.dto.mapper.ClientUpdateRequestDtoMapper;
import org.neoris.microservices.clients.infrastructure.api.dto.mapper.ClientUpdateRequestDtoMapperImpl;
import org.neoris.microservices.clients.infrastructure.api.dto.request.ClientRequestDTO;
import org.neoris.microservices.clients.infrastructure.api.dto.request.ClientUpdateRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class ClientControllerTest {

  @Mock
  private ClientSaveService clientSaveService;
  @Mock
  private ClientUpdateService clientUpdateService;
  @Mock
  private ClientGetService clientGetService;
  @Mock
  private ClientDeleteService clientDeleteService;
  private SaveClientService saveClientService;
  private GetClientService getClientService;
  private UpdateClientService updateClientService;
  private DeleteClientService deleteClientService;
  private ClientRequestDtoMapper clientRequestDtoMapper;
  private ClientResponseDtoMapper clientResponseDtoMapper;
  private ClientUpdateRequestDtoMapper clientUpdateRequestDtoMapper;
  @InjectMocks
  private ClientController clientController;
  private MockMvc mockMvc;

  private Gson gson = new Gson();

  @BeforeEach
  public void clientController() {
    saveClientService = new SaveClientService(clientSaveService);
    getClientService = new GetClientService(clientGetService);
    updateClientService = new UpdateClientService(clientUpdateService);
    deleteClientService = new DeleteClientService(clientDeleteService, clientGetService);
    clientRequestDtoMapper = new ClientRequestDtoMapperImpl();
    clientResponseDtoMapper = new ClientResponseDtoMapperImpl();
    clientUpdateRequestDtoMapper = new ClientUpdateRequestDtoMapperImpl();
    clientController = new ClientController(saveClientService, getClientService,
        updateClientService, deleteClientService, clientRequestDtoMapper, clientResponseDtoMapper,
        clientUpdateRequestDtoMapper);
    mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
  }

  private String jsonRequest(String path) throws FileNotFoundException {
    Reader reader = new InputStreamReader(this.getClass().getResourceAsStream(path));
    ClientRequestDTO requestDTO = gson.fromJson(reader, ClientRequestDTO.class);
    return gson.toJson(requestDTO);
  }

  @Test
  void saveJoseLema() throws Exception {
    String request = jsonRequest("/JoseLema.json");
    RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/clientes")
        .contentType(MediaType.APPLICATION_JSON)
        .content(request);
    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
  }

  @Test
  void saveJuanOsorio() throws Exception {
    String request = jsonRequest("/JuanOsorio.json");
    RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/clientes")
        .contentType(MediaType.APPLICATION_JSON)
        .content(request);
    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
  }

  @Test
  void saveMarianela() throws Exception {
    String request = jsonRequest("/Marianela.json");
    RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/clientes")
        .contentType(MediaType.APPLICATION_JSON)
        .content(request);
    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
  }

  @Test
  void update() throws Exception {
    ClientUpdateRequestDto updateRequestDto = updateRequestDtoBuilder();
    String request = gson.toJson(updateRequestDto);
    Client client = buildGetClient("1143364975", "Otavalo sn y principal Avenida");
    client.setStatus(null);
    Mockito.when(clientUpdateService.update(Mockito.any(Client.class))).thenReturn(client);
    RequestBuilder requestBuilder = MockMvcRequestBuilders
        .put("/clientes")
        .contentType(MediaType.APPLICATION_JSON)
        .content(request);
    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
  }

  @Test
  void searchById() throws Exception {
    Client client = buildGetClient("1143364975", "Otavalo sn y principal");

    Mockito.when(clientGetService.getByDocumentId("1143364975")).thenReturn(client);

    RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/clientes")
        .param("clientId", "1143364975")
        .contentType(MediaType.APPLICATION_JSON);
    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    assertEquals(result.getResponse().getContentAsString(), gson.toJson(client));
  }

  @Test
  void deleteById() throws Exception {
    Client client = buildGetClient("1143364975", "Otavalo sn y principal");
    Mockito.when(clientGetService.getByDocumentId("1143364975")).thenReturn(client);
    RequestBuilder requestBuilder = MockMvcRequestBuilders
        .delete("/clientes")
        .param("clientId", "1143364975")
        .contentType(MediaType.APPLICATION_JSON);
    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
  }

  private Client buildGetClient(String documentId, String address) {
    return Client.builder()
        .id(1L)
        .password("1234")
        .status(true)
        .name("Jose Lema")
        .gender("MASCULINO")
        .age(24)
        .documentId(documentId)
        .address("Otavalo sn y principal")
        .phone("098254785")
        .build();
  }

  private ClientUpdateRequestDto updateRequestDtoBuilder() {
    ClientUpdateRequestDto updateRequestDto = new ClientUpdateRequestDto();
    updateRequestDto.setAddress("Otavalo sn y principal Avenida");
    updateRequestDto.setId(1L);
    updateRequestDto.setGender("MASCULINO");
    updateRequestDto.setAge(24);
    updateRequestDto.setPassword("1234");
    updateRequestDto.setPhone("098254785");
    updateRequestDto.setName("Jose Lema");
    updateRequestDto.setDocumentId("1143364975");
    return updateRequestDto;
  }
}