package com.xinerji.tmaxxfindto.common;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class ApiError {
  private int status;
  private String[] messages;
  private Timestamp timestamp;
  private String errorType;

  public ApiError(int status, String message, Timestamp timestamp, String errorType) {
    this.status = status;
    this.messages = new String[1];
    this.messages[0] = message;
    this.timestamp = timestamp;
    this.errorType = errorType;
  }

  public ApiError(int status, String[] messages, Timestamp timestamp, String errorType) {
    this.status = status;
    this.messages = messages;
    this.timestamp = timestamp;
    this.errorType = errorType;
  }
}
