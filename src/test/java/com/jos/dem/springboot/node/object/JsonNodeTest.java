package com.jos.dem.springboot.node.object;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import com.jos.dem.springboot.node.object.model.Person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonNodeTest {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Test
  @DisplayName("Validate Person to Json Node transformation")
  void shouldGetJsonNodeFromPerson() throws Exception {
    log.info("Running: Validate person to json node transformation at " + new Date());
    Person person = new Person("josdem","joseluis.delacruz@gmail.com");
    assertNotNull(person);
  }


}
