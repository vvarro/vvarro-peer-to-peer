package com.greenfox.service;

import com.greenfox.model.Log;
import com.greenfox.repository.MessageRepository;
import com.greenfox.repository.UserRepository;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class MainControllerService {

  @Autowired
  UserRepository userRepository;
  @Autowired
  MessageRepository messageRepository;

  public String callEndpoint(HttpServletRequest request) throws ParseException {
    Log log = new Log(request);
    if (userRepository.count() == 0) {
      return "redirect:/enter";
    }
    return "";
  }

  public void addAttribute(Model model){
    model.addAttribute("username", userRepository.findOne((long) 1).getName());
    model.addAttribute("messages", messageRepository.findAll());
  }
}
