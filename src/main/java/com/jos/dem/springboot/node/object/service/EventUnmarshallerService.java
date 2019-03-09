package com.jos.dem.springboot.node.object.service;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;

import com.jos.dem.springboot.node.object.model.Event;

public interface EventUnmarshallerService {

  Event read(File jsonFile) throws IOException;

}
