package com.jos.dem.springboot.json.node.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jos.dem.springboot.json.node.model.Event;
import com.jos.dem.springboot.json.node.service.UnmarshallerService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class UnmarshallerServiceImpl implements UnmarshallerService {

    private ObjectMapper mapper = new ObjectMapper();

    @PostConstruct
    public void setup() {
        mapper.registerModule(new JavaTimeModule());
    }

    public Event read(File jsonFile) throws IOException {
        InputStream inputStream = new FileInputStream(jsonFile);
        JsonNode jsonNode = mapper.readTree(inputStream);
        return mapper.treeToValue(jsonNode, Event.class);
    }

}
