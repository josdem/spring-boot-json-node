package com.jos.dem.springboot.json.node.model;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
  private Integer id;
  private String nickname;
  private String email;
}
