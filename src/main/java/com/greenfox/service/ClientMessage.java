package com.greenfox.service;

import com.greenfox.model.Client;
import com.greenfox.model.Message;

public class ClientMessage {
  public Client client;
  public Message message;

  public ClientMessage() {
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Message getMessage() {
    return message;
  }

  public void setMessage(Message message) {
    this.message = message;
  }
}
