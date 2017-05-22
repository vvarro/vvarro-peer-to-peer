package com.greenfox.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Table(name = "users")
@Entity
@Component
public class User {
  @Id
  int id;
  String name;

  public User(String name) {
    this.id = 1000000 + (int)(Math.random() * (99999999-1000000));
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
