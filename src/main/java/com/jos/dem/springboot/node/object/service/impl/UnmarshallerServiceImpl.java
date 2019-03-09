package com.jos.dem.springboot.node.object.service.impl;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;

import com.jos.dem.springboot.node.object.model.Event;
import com.jos.dem.springboot.node.object.service.UnmarshallerService;

@Service
public class UnmarshallerServiceImpl implements UnmarshallerService {

  private ObjectMapper mapper = new ObjectMapper();

  public Event read(File jsonFile) throws IOException {
    InputStream inputStream = new FileInputStream(jsonFile);
    JsonNode jsonNode = mapper.readTree(inputStream);
    return mapper.treeToValue(jsonNode, Event.class);
  }

}
