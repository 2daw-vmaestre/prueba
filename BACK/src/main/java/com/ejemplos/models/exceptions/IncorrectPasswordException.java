package com.ejemplos.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class IncorrectPasswordException extends RuntimeException {

  private static final long serialVersionUID = 3220735874915464565L;

  public IncorrectPasswordException() {
    super();
  }

  public IncorrectPasswordException(String message) {
    super(message);
  }

  public IncorrectPasswordException(String message, Throwable cause) {
    super(message, cause);
  }

  public IncorrectPasswordException(Throwable cause) {
    super(cause);
  }
}
