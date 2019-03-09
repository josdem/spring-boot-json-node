package com.jos.dem.springboot.node.object;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;

import com.jos.dem.springboot.node.object.service.JsonNodeService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JsonNodeServiceTest {

  @Autowired
  private JsonNodeService jsonNodeService;

  private File jsonFile = new File("src/main/resources/ClockIn.json");

  @Test
  @DisplayName("Should get Json Node from ClockIn Json file")
  public void shouldGetJsonNode() {
    InputStream targetStream = new FileInputStream(jsonFile);
    assertNotNull(jsonNodeService.read(inputStream));
  }

}
