package com.jos.dem.springboot.json.node.service;

import java.io.File;
import java.io.IOException;

import com.jos.dem.springboot.json.node.model.Event;

public interface UnmarshallerService {

  Event read(File jsonFile) throws IOException;

}
