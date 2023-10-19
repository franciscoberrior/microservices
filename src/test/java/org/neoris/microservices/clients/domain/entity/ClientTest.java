package org.neoris.microservices.clients.domain.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClientTest {

  private Client client;

  @BeforeEach
  public void init() {
    this.client = Client.builder()
        .id(1L)
        .password("123")
        .status(true)
        .age(24)
        .address("Otavalo sn y principal")
        .documentId("1143364975")
        .gender("MASCULINO")
        .name("Jose Lema")
        .phone("098254785")
        .build();
  }

  @Test
  void getId() {
    Long id = client.getId();
    Assertions.assertEquals(id, 1L);
  }

  @Test
  void getPassword() {
    String password = client.getPassword();
    Assertions.assertEquals(password, "123");
  }

  @Test
  void getStatus() {
    boolean status = client.getStatus();
    Assertions.assertEquals(status, true);
  }

  @Test
  void setId() {
    client.setId(1L);
    Assertions.assertEquals(client.getId(), 1L);
  }

  @Test
  void setPassword() {
    client.setPassword("321");
    Assertions.assertEquals(client.getPassword(), "321");
  }

  @Test
  void setStatus() {
    client.setStatus(false);
    Assertions.assertEquals(client.getStatus(), false);
  }
}