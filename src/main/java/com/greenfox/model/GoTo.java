package com.greenfox.model;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

public class GoTo extends HttpServlet {

  public void doGet(HttpServletResponse res) throws ServletException,
      IOException {
    String url = "https://vvarro-p2p.herokuapp.com";
    res.sendRedirect(url);
  }
}
