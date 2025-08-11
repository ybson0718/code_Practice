package ks.ac.kr.board_demo.global.exception;

import ks.ac.kr.board_demo.global.exception.domain.UnauthorizedException;
import ks.ac.kr.board_demo.global.exception.dto.ExceptionCode;
import ks.ac.kr.board_demo.global.exception.dto.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ExceptionResponse> handleException(final UnauthorizedException e) {
        ExceptionCode exception = e.getCode();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ExceptionResponse(exception.getCode(), exception.getMessage()));
    }

}
