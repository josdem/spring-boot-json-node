package com.jos.dem.springboot.node.object;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.jos.dem.springboot.node.object.model.Person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonNodeTest {

  private ObjectMapper mapper = new ObjectMapper();
  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Test
  @DisplayName("Validate Json to Json Node transformation")
  void shouldGetJsonNodeFromJson() throws Exception {
    log.info("Running: Validate json to json node transformation at " + new Date());

    String json = "{\"id\":1196,\"nickname\":\"josdem\",\"email\":\"joseluis.delacruz@gmail.com\"}";
    JsonNode node = mapper.readTree(json);

    assertAll("person",
      () -> assertEquals(1196, node.get("id").intValue(), "Should get id"),
      () -> assertEquals("josdem", node.get("nickname").textValue(), "Should get nickname"),
      () -> assertEquals("email", node.get("email").textValue(), "should get email")
    );

  }


  @Test
  @DisplayName("Validate Person to Json Node transformation")
  void shouldGetJsonNodeFromPerson() throws Exception {
    log.info("Running: Validate person to json node transformation at " + new Date());
    Person person = new Person(1196, "josdem","joseluis.delacruz@gmail.com");
    JsonNode node = mapper.valueToTree(person);

    assertAll("person",
      () -> assertEquals(1196, node.get("id").intValue(), "Should get id"),
      () -> assertEquals("josdem", node.get("nickname").textValue(), "Should get nickname"),
      () -> assertEquals("email", node.get("email").textValue(), "should get email")
    );

  }

}
