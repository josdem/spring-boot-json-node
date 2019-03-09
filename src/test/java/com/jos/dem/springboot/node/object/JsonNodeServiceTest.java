package com.jos.dem.springboot.node.object;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.jos.dem.springboot.node.object.model.Event;
import com.jos.dem.springboot.node.object.service.JsonNodeReaderService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JsonNodeServiceTest {

  @Autowired
  private JsonNodeReaderService service;

  @Test
  @DisplayName("Should get Json Node from ClockIn Json file")
  public void shouldGetJsonNode() throws Exception {
    File jsonFile = new File("src/main/resources/ClockIn.json");
    Event event = service.read(jsonFile);

    assertAll("event",
      () -> assertEquals("fbe07c89-ffa7-4c86-9832-5f75cf765737", event.getBatchId(), "Should get batch id"),
      () -> assertEquals("EmployeeClockIn", event.getEventType(), "Should get event type")
    );

  }

}
