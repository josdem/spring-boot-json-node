package com.jos.dem.springboot.node.object.service;

import java.io.File;
import java.io.IOException;

import com.jos.dem.springboot.node.object.model.Event;

public interface UnmarshallerService {

  Event read(File jsonFile) throws IOException;

}
