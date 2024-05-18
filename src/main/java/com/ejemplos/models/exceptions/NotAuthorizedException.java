package com.ejemplos.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NotAuthorizedException extends RuntimeException {

  private static final long serialVersionUID = 3220735874915464565L;

  public NotAuthorizedException() {
    super();
  }

  public NotAuthorizedException(String message) {
    super(message);
  }

  public NotAuthorizedException(String message, Throwable cause) {
    super(message, cause);
  }

  public NotAuthorizedException(Throwable cause) {
    super(cause);
  }
}
