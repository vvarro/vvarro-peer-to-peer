package com.greenfox.controller;

import com.greenfox.repository.MessageRepository;
import com.greenfox.service.ClientMessage;
import com.greenfox.service.MessageValidator;
import com.greenfox.service.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RecievedMessageController {
  private static String logLevel = System.getenv("CHAT_APP_LOGLEVEL");
  private static final String url = System.getenv("CHAT_APP_PEER_ADDRESS") + "/api/message/receive";
  private static final String privateId = System.getenv("CHAT_APP_UNIQUE_ID");

  @Autowired
  private MessageRepository messageRepository;

  @PostMapping("/api/message/receive")
  @CrossOrigin("*")
  public ResponseMessage validateMessage (@RequestBody ClientMessage clientMessage) {
    MessageValidator messageValidator = new MessageValidator();
    if(messageValidator.validate(clientMessage).getStatus().equals("ok") && !messageRepository.exists(clientMessage.getMessage().getId())){
      RestTemplate restTemplate = new RestTemplate();
      restTemplate.postForObject(url, clientMessage,ResponseMessage.class);
      messageRepository.save(clientMessage.getMessage());
    }
    return messageValidator.validate(clientMessage);
  }
}
