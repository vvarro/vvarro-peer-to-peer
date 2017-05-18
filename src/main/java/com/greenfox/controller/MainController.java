package com.greenfox.controller;

import com.greenfox.model.Log;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  @RequestMapping(value = "/")
  public String log(HttpServletRequest request) throws ParseException {
    if(System.getenv("CHAT_APP_LOGLEVEL").equals("ERROR")) {
    System.err.println("ERROR");
    } else {
      Log log = new Log(request);
      System.out.println(log);
    }
    return "index";
  }
}
