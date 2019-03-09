package com.jos.dem.springboot.node.object.service;

import java.io.InputStream;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;

public interface JsonNodeReaderService {

  JsonNode read(InputStream inputStream) throws IOException;

}
