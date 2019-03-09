package com.jos.dem.springboot.node.object.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.databind.JsonNode;

@Getter
@Setter
public class StoreMessagePayload {
  private String messageId;
  private OffsetDateTime eventAt;
  private JsonNode data;
}
