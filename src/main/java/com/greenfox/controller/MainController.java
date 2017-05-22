package com.greenfox.controller;

import com.greenfox.model.Log;
import com.greenfox.repository.MessageRepository;
import com.greenfox.repository.UserRepository;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  public String errorNoUser;

  @Autowired
  UserRepository userRepository;
  @Autowired
  MessageRepository messageRepository;

  @GetMapping("/")
  public String mainPage(HttpServletRequest request, Model model) throws ParseException {
    Log log = new Log(request);
    if (userRepository.count() == 0) {
      return "redirect:/enter";
    } else {
      model.addAttribute("username", userRepository.findOne((long)1).getName());
      model.addAttribute("messages", messageRepository.findAll());
      return "index";
    }
  }

  @PutMapping("/update")
  public String updateUser(@RequestParam("newusername") String newUsername,
      HttpServletRequest request, Model model) throws Exception {
    Log log = new Log(request);
    if (userRepository.count() == 0) {
      return "redirect:/enter";
    } else if (newUsername.isEmpty()) {
      errorNoUser = "The username field is empty";
      return "index";
    } else {
      userRepository.findOne((long) 1).setName(newUsername);
      userRepository.save(userRepository.findOne((long) 1));
      model.addAttribute("error", errorNoUser);
      model.addAttribute("username", userRepository.findOne((long) 1).getName());
      model.addAttribute("messages", messageRepository.findAll());
      return "index";
    }
  }
}