package com.greenfox.service;

import java.util.ArrayList;
import java.util.List;

public class MessageValidator {

  public MessageValidator() {
  }

  public ResponseMessage validate(ClientMessage clientMessage) {
    ResponseMessage responseMessage = new ResponseMessage();
    List<String> missingParams = new ArrayList<>();
    if (clientMessage.getClient().getId().isEmpty() || clientMessage.getClient().getId() == null) {
      missingParams.add("client.id");
    }
    if (clientMessage.getMessage().getText().isEmpty()
        || clientMessage.getMessage().getText() == null) {
      missingParams.add("message.text");
    }
    if (clientMessage.getMessage().getUsername().isEmpty()
        || clientMessage.getMessage().getUsername() == null) {
      missingParams.add("message.username");
    }
    if (clientMessage.getMessage().getTimestamp() == null) {
      missingParams.add("message.timestamp");
    }
    if (clientMessage.getMessage().getId() == 0L) {
      missingParams.add("message.id");
    }
    if (missingParams.size() == 0) {
      responseMessage.status = "ok";
      responseMessage.message = null;
    } else {
      for (String missing : missingParams) {
        responseMessage.message += missing + ", ";
      }
      responseMessage.message = "Missing field(s): " + responseMessage.getMessage().substring(4, (responseMessage.getMessage().length()-2));
      responseMessage.status = "error";
    }
    return responseMessage;
  }

}