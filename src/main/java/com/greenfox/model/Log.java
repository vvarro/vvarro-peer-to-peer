package com.greenfox.model;

import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;

public class Log {
  long dateandtime;
  String loglevel;
  String request;
  String path;
  String method;
  String message;

  public Log(HttpServletRequest request) throws ParseException {
    this.dateandtime = request.getSession().getCreationTime();
    this.loglevel = String.valueOf(System.getenv("CHAT_APP_LOGLEVEL"));
    this.request = "Request";
    this.path = String.valueOf(request.getServletPath());
    this.method = String.valueOf(request.getMethod());
    this.message = String.valueOf(request.getPathInfo());
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public long getDateandtime() {
    return dateandtime;
  }

  public void setDateandtime(long dateandtime) {
    this.dateandtime = dateandtime;
  }

  public String getLoglevel() {
    return loglevel;
  }

  public void setLoglevel(String loglevel) {
    this.loglevel = loglevel;
  }

  public String getRequest() {
    return request;
  }

  public void setRequest(String request) {
    this.request = request;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString(){
   return getDateandtime() + getLoglevel() + getRequest() + getPath() + getMethod() + getMessage();
  }

}