package com.greenfox.model;

import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;

public class Log {

  String path;
  String method;
  long dateandtime;
  String request;
  String loglevel;
  String requestdata;
  String message;

  public Log(HttpServletRequest request) throws ParseException {
    this.dateandtime = request.getSession().getCreationTime();
    this.loglevel = System.getenv("CHAT_APP_LOGLEVEL");
    this.request = "Request";
    this.path = request.getServletPath();
    this.method = request.getMethod();
    this.message = request.getPathInfo();
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

  public String getRequestdata() {
    return requestdata;
  }

  public void setRequestdata(String requestdata) {
    this.requestdata = requestdata;
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
}