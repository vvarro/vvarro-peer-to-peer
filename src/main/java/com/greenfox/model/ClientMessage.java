package com.greenfox.model;

public class ClientMessage {
  public Client client;
  public Message message;

  public ClientMessage() {
  }

  public ClientMessage(Client client, Message message) {
    this.client = client;
    this.message = message;
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
