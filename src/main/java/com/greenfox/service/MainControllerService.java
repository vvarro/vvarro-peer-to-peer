package com.greenfox.service;

import com.greenfox.model.Message;
import com.greenfox.repository.MessageRepository;
import com.greenfox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class MainControllerService {
  private static final String url = System.getenv("CHAT_APP_PEER_ADDRESS") + "/api/message/receive";

  @Autowired
  UserRepository userRepository;
  @Autowired
  MessageRepository messageRepository;

  public void addAttribute(Model model){
    model.addAttribute("username", userRepository.findOne((long) 1).getName());
    model.addAttribute("messages", messageRepository.findAllByOrderByTimestampAsc());
  }

  public void sendNewMessage(String send){
    ClientMessage clientMessage = new ClientMessage();
    clientMessage.getClient().setId(userRepository.findOne((long) 1).getName());
    clientMessage.setMessage(new Message(send, userRepository.findOne((long) 1).getName()));
   // RestTemplate restTemplate = new RestTemplate();
   // restTemplate.postForObject(url, clientMessage,ResponseMessage.class);
    messageRepository.save(new Message(send, userRepository.findOne((long) 1).getName()));
  }
}
