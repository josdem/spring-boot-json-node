package com.jos.dem.springboot.node.object;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;

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
    assertNotNull(service.read(jsonFile));
  }

}
