package com.jos.dem.springboot.node.object;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.jos.dem.springboot.node.object.model.Person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonNodeTest {

  private JsonNode node;
  private ObjectMapper mapper = new ObjectMapper();
  private Logger log = LoggerFactory.getLogger(this.getClass());

  @BeforeEach
  void init() throws Exception {
    log.info("Getting Json Node from Json");
    String json = "{\"id\":1196,\"nickname\":\"josdem\",\"email\":\"joseluis.delacruz@gmail.com\"}";
    node = mapper.readTree(json);
  }


  @Test
  @DisplayName("Validate Json to Json Node transformation")
  void shouldGetJsonNodeFromJson() throws Exception {
    log.info("Running: Validate json to json node transformation at {}", new Date());

    assertAll("node",
      () -> assertEquals(1196, node.get("id").intValue(), "Should get id"),
      () -> assertEquals("josdem", node.get("nickname").textValue(), "Should get nickname"),
      () -> assertEquals("email", node.get("email").textValue(), "should get email")
    );

  }

  @Test
  @DisplayName("Validate Json Node to Person transformation")
  void shouldGetPersonFromJsonNode() throws Exception {
    log.info("Running: Validate json to json node transformation at {}", new Date());

    Person person = mapper.treeToValue(node, Person.class);

    assertAll("person",
      () -> assertEquals(1196, person.getId(), "Should get id"),
      () -> assertEquals("josdem", person.getNickname(), "Should get nickname"),
      () -> assertEquals("email", person.getEmail(), "should get email")
    );

  }

  @Test
  @DisplayName("Validate Person to Json Node transformation")
  void shouldGetJsonNodeFromPerson() throws Exception {
    log.info("Running: Validate person to json node transformation at {}", new Date());
    Person person = new Person(1196, "josdem","joseluis.delacruz@gmail.com");
    JsonNode node = mapper.valueToTree(person);

    assertAll("person",
      () -> assertEquals(1196, node.get("id").intValue(), "Should get id"),
      () -> assertEquals("josdem", node.get("nickname").textValue(), "Should get nickname"),
      () -> assertEquals("email", node.get("email").textValue(), "should get email")
    );

  }

  @Test
  @DisplayName("Validate Arguments to Json Node transformation")
  void shouldGetJsonNodeFromArguments() throws Exception {
    log.info("Running: Validate arguments to json node transformation at {}", new Date());
    Integer id = 1196;
    String nickname = "josdem";
    String email = "joseluis.delacruz@gmail.com";

    JsonNode node = mapper.createObjectNode();
    ((ObjectNode) node).put("id", 2016);
    ((ObjectNode) node).put("name", "baeldung.com");

    assertAll("person",
      () -> assertEquals(1196, node.get("id").intValue(), "Should get id"),
      () -> assertEquals("josdem", node.get("nickname").textValue(), "Should get nickname"),
      () -> assertEquals("email", node.get("email").textValue(), "should get email")
    );

  }

  @AfterEach
  void finish() throws Exception {
    log.info("Test execution finished");
  }

}
