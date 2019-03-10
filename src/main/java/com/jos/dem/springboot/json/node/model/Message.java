package com.jos.dem.springboot.json.node.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import com.fasterxml.jackson.databind.JsonNode;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {
  private String messageId;
  private OffsetDateTime eventAt;
  private JsonNode data;
}
