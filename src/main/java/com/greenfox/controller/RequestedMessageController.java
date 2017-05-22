package com.greenfox.controller;

import com.greenfox.model.ClientMessage;
import com.greenfox.service.MessageValidator;
import com.greenfox.service.ResponseMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestedMessageController {

  @PostMapping("/api/message/receive")
  public ResponseMessage validateMessage (@RequestBody ClientMessage clientMessage) {
    MessageValidator messageValidator = new MessageValidator();
    return messageValidator.validate(clientMessage);
  }
}
