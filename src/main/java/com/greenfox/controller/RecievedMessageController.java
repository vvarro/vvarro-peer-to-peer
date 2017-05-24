package com.greenfox.controller;

import com.greenfox.model.ClientMessage;
import com.greenfox.model.Message;
import com.greenfox.repository.MessageRepository;
import com.greenfox.service.MessageValidator;
import com.greenfox.service.ResponseMessage;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RecievedMessageController {
  private static String logLevel = System.getenv("CHAT_APP_LOGLEVEL");
  private static final String url = System.getenv("CHAT_APP_PEER_ADDRESS") + "/api/message/receive";
  private static final String uniqueId = System.getenv("CHAT_APP_UNIQUE_ID");
  private static final String projectUrl = "https://vvarro-p2p.herokuapp.com";

  @Autowired
  private MessageRepository messageRepository;

  @PostMapping("/api/message/receive")
  @CrossOrigin("*")
  public ResponseMessage validateMessage (@RequestBody ClientMessage clientMessage){
    MessageValidator messageValidator = new MessageValidator();
    if(messageValidator.validate(clientMessage).getStatus().equals("ok") && !clientMessage.getClient().getId().equals(uniqueId)){
      Message receivedMessage = clientMessage.getMessage();
      messageRepository.save(receivedMessage);
      RestTemplate restTemplate = new RestTemplate();
      restTemplate.postForObject(url, clientMessage,ResponseMessage.class);
      HttpHeaders headers = new HttpHeaders();
      headers.setLocation(URI.create("/"));
    }
    return messageValidator.validate(clientMessage);
  }

}
