package com.greenfox.model;

import org.springframework.stereotype.Component;

@Component
public class User {
  int id;
  String name;

  public User(String name) {
    this.id = 0;
    this.name = name;
  }

  public User() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
