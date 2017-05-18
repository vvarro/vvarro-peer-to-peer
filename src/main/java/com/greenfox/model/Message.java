package com.greenfox.model;

import java.sql.Timestamp;

public class Message {
  long id;
  String username;
  String text;
  Timestamp timestamp;

  public Message() {
    this.timestamp = new Timestamp(System.currentTimeMillis());;
  }

  public Message(long id, String username, String text, Timestamp timestamp) {
    this.id = id;
    this.username = username;
    this.text = text;
    this.timestamp = timestamp;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }
}
