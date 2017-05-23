package com.greenfox.service;

import static com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.NON_NULL;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include= NON_NULL)
public class ResponseMessage {
  String status;
  @JsonSerialize(include= NON_NULL)
  String message;

  public ResponseMessage() {
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
