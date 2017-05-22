package com.greenfox.service;

import com.greenfox.model.ClientMessage;

public class MessageValidator {

  public MessageValidator() {
  }

  public ResponseMessage validate(ClientMessage clientMessage) {
    ResponseMessage responseMessage = new ResponseMessage();
    responseMessage.setMessage(clientMessage.message.getText());
    responseMessage.setStatus(clientMessage.client.getId());
    return responseMessage;
  }
}