package com.greenfox.controller;

public class ExceptionController {

  String error;

  public ExceptionController(String error) {
    this.error = error;
  }

  public String getError() {
    return error;
  }
}
