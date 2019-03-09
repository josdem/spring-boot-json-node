package com.jos.dem.springboot.node.object;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {
  private String batchId;
  private String eventType;
  private String publisher;
  private String publisherVersion;
  private OffsetDateTime publishedAt;
  private Message[] messages;
}
