package com.example.taskmanager.exception;

public class GeneralExceptionHandler extends RuntimeException {
  public GeneralExceptionHandler(String message) {
    super(message);
  }
}
