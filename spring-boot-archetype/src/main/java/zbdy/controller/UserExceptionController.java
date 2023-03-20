package zbdy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import zbdy.exception.UserNotfoundException;

@ControllerAdvice
public class UserExceptionController {
	
	@ExceptionHandler(UserNotfoundException.class)
	public ResponseEntity<Object> exception(UserNotfoundException exception){
		return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
	}
}
