package com.greenfox.service;

import com.greenfox.repository.MessageRepository;
import com.greenfox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class MainControllerService {

  @Autowired
  UserRepository userRepository;
  @Autowired
  MessageRepository messageRepository;

  public void addAttribute(Model model){
    model.addAttribute("username", userRepository.findOne((long) 1).getName());
    model.addAttribute("messages", messageRepository.findAll());
  }
}
