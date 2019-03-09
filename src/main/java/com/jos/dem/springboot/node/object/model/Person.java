package com.jos.dem.springboot.node.object.model;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;

@Setter
@Getter
@AllArgsConstructor
public class Person {
  private String nickname;
  private String email;
}
