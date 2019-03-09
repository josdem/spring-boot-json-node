package com.jos.dem.springboot.node.object.service.impl;

import java.io.InputStream;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.stereotype.Service;

import com.jos.dem.springboot.node.object.service.JsonNodeReaderService;

@Service
public class JsonNodeReaderServiceImpl implements JsonNodeReaderService {

  private ObjectMapper mapper = new ObjectMapper();

  public JsonNode read(InputStream inputStream) throws IOException {
    return  mapper.readTree(inputStream);
  }

}
