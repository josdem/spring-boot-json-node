package com.jos.dem.springboot.node.object.service;

import java.io.InputStream;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;

import com.jos.dem.springboot.node.object.model.Event;

public interface JsonNodeReaderService {

  Event read(InputStream inputStream) throws IOException;

}
