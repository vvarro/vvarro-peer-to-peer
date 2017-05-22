package com.greenfox.controller;

import com.greenfox.model.Log;
import com.greenfox.model.User;
import com.greenfox.repository.UserRepository;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

  @Autowired
  User user;
  UserRepository userRepository;

  public LoginController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @RequestMapping("/")
  public String mainPage(HttpServletRequest request, Model model) throws Exception {
    if (System.getenv("CHAT_APP_LOGLEVEL").equals("ERROR")) {
      System.err.println("ERROR");
    } else {
      Log log = new Log(request);
      System.out.println(log.toString());
    }
    if (userRepository.count() == 0) {
      return "redirect:/enter";
    }
    return "index";
  }

  @RequestMapping("/enter")
  public String log(Model model) {
    model.addAttribute("user", user);
    if (userRepository.count() > 0) {
      return "redirect:/index";
    }
    return "enter";
  }

  @PostMapping("/enter/add")
  public String addNewUser(@RequestParam("newuser") String param) throws InterruptedException {
    User user = new User(param);
    System.out.println(user.getName());
    if (userRepository.count() > 0) {
      return "redirect:/index";
    }
    return "redirect:/";
  }
}
