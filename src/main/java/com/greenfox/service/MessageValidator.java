package com.greenfox.service;

import com.greenfox.model.Client;
import com.greenfox.model.Message;

public class MessageValidator {
  int code;
  String status;
  String message;

  public MessageValidator() {

  }

  public void Vaidate(Message receivedMessage, Client client) {
    if (client.getId().equals(null)) {
      if (!this.message.isEmpty()) {
        this.message.concat(", ");
      }
      this.message.concat("client. id");
      this.status = "error";
      this.code = 401;
    } else if (receivedMessage.getId() == 0) {
      if (!this.message.isEmpty()) {
        this.message.concat(", ");
      }
      this.message.concat("message.id");
      this.status = "error";
      this.code = 401;
    } else if (receivedMessage.getText().equals(null)) {
      if (this.message.isEmpty()) {
        this.message.concat(", ");
      }
      this.message.concat("message.text");
      this.status = "error";
      this.code = 401;
    } else if (receivedMessage.getTimestamp().equals(null)) {
      if (!this.message.isEmpty()) {
        this.message.concat(", ");
      }
      this.message.concat("message.timestamp");
      this.status = "error";
      this.code = 401;
    } else if (receivedMessage.getUsername().equals(null)) {
      if (!this.message.isEmpty()) {
        this.message.concat(", ");
      }
      this.message.concat("message.username");
      this.status = "error";
      this.code = 401;
    } else {
      this.status = "ok";
      this.message = "";
      this.code = 200;
    }
  }



  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
