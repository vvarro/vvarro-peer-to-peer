package com.greenfox.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "messages")
@Entity
public class Message {

  @Id
  long id;
  String username;
  String text;
  Timestamp timestamp;

  public Message() {
  }

  public Message(long id, String username, String text, Timestamp timestamp) {
    this.id = 1000000 + (int) (Math.random() * (99999999 - 1000000));
    this.username = username;
    this.text = text;
    this.timestamp = new Timestamp(System.currentTimeMillis());
  }

  public Message(String text, String username) {
    this.id = 1000000 + (int) (Math.random() * (99999999 - 1000000));
    this.text = text;
    this.username = username;
    this.timestamp = new Timestamp(System.currentTimeMillis());
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
