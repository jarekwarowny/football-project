package com.kodilla.footballproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CoachNotFoundException.class)
    public ResponseEntity<Object> handleCoachNotFoundException(CoachNotFoundException exception) {
        return new ResponseEntity<>("Coach with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MatchNotFoundException.class)
    public ResponseEntity<Object> handleMatchNotFoundException(CoachNotFoundException exception) {
        return new ResponseEntity<>("Match with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<Object> handlePlayerNotFoundException(CoachNotFoundException exception) {
        return new ResponseEntity<>("Player with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TeamNotFoundException.class)
    public ResponseEntity<Object> handleTeamNotFoundException(CoachNotFoundException exception) {
        return new ResponseEntity<>("Team with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TeamCoachNotFoundException.class)
    public ResponseEntity<Object> handleTeamCoachNotFoundException(CoachNotFoundException exception) {
        return new ResponseEntity<>("Team Coach with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TeamPlayerNotFoundException.class)
    public ResponseEntity<Object> handleTeamPlayerNotFoundException(CoachNotFoundException exception) {
        return new ResponseEntity<>("Team Player with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TreningNotFoundException.class)
    public ResponseEntity<Object> handleTreningNotFoundException(CoachNotFoundException exception) {
        return new ResponseEntity<>("Trening with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }
}
