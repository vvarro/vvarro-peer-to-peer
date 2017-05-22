package com.greenfox.controller;

import com.greenfox.model.Log;
import com.greenfox.model.User;
import com.greenfox.repository.UserRepository;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
  public String errorNoUser;

  @Autowired
  UserRepository userRepository;

  @GetMapping("/enter")
  public String log(Model model, HttpServletRequest request) throws ParseException {
    Log log = new Log(request);
    model.addAttribute("users", userRepository);
    model.addAttribute("error", errorNoUser);
    if (userRepository.count() > 0) {
      return "redirect:/";
    } else {
      return "enter";
    }
  }

  @PostMapping("/enter/add")
  public String addNewUser(@RequestParam("newuser") String param, HttpServletRequest request)
      throws ParseException {
    Log log = new Log(request);
    if (userRepository.count() > 0) {
      return "redirect:/index";
    }
    if (param.isEmpty()){
      errorNoUser = "The username field is empty";
      return "redirect:/enter";
    } else {
      userRepository.save(new User(param));
      return "redirect:/";
    }
  }
}
