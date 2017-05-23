package com.greenfox.controller;

import com.greenfox.model.Message;
import com.greenfox.repository.MessageRepository;
import com.greenfox.repository.UserRepository;
import com.greenfox.service.ClientMessage;
import com.greenfox.service.MainControllerService;
import com.greenfox.service.ResponseMessage;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {

  private static final String url = System.getenv("CHAT_APP_PEER_ADDRESS") + "/api/message/receive";
  private static final String privateId = System.getenv("CHAT_APP_UNIQUE_ID");

  public String errorNoUser;

  @Autowired
  UserRepository userRepository;
  @Autowired
  MessageRepository messageRepository;
  @Autowired
  MainControllerService mainControllerService;

  @GetMapping("/")
  public String mainPage(HttpServletRequest request, Model model) throws Exception {
    mainControllerService.callEndpoint(request);
    model.addAttribute("error", errorNoUser);
    mainControllerService.addAttribute(model);
//    model.addAttribute("username", userRepository.findOne((long) 1).getName());
//    model.addAttribute("messages", messageRepository.findAll());
    return "index";
  }

  @GetMapping("/update")
  public String updateUser(@RequestParam("newusername") String newUsername,
      HttpServletRequest request, Model model) throws Exception {
    mainControllerService.callEndpoint(request);
    if (newUsername.isEmpty()) {
      errorNoUser = "The username field is empty";
      return "redirect:/";
    } else {
      userRepository.findOne((long) 1).setName(newUsername);
      userRepository.save(userRepository.findOne((long) 1));
      mainControllerService.addAttribute(model);
//    model.addAttribute("username", userRepository.findOne((long) 1).getName());
//    model.addAttribute("messages", messageRepository.findAll());
      return "index";
    }
  }

  @PostMapping("/send")
  public String sendMessage(@RequestParam("send") String send,
      HttpServletRequest request, Model model) throws Exception {
    mainControllerService.callEndpoint(request);
    ClientMessage clientMessage = new ClientMessage();
    clientMessage.getClient().setId(userRepository.findOne((long) 1).getName());
    clientMessage.setMessage(new Message(send, userRepository.findOne((long) 1).getName()));
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.postForObject(url, clientMessage, ResponseMessage.class);
    messageRepository.save(new Message(send, userRepository.findOne((long) 1).getName()));
    mainControllerService.addAttribute(model);
//    model.addAttribute("username", userRepository.findOne((long) 1).getName());
//    model.addAttribute("messages", messageRepository.findAll());
    return "redirect:/";
  }
}
