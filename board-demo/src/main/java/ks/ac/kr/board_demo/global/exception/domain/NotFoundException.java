package ks.ac.kr.board_demo.global.exception.domain;

import ks.ac.kr.board_demo.global.exception.dto.ExceptionCode;
import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

  ExceptionCode code;

    public NotFoundException(ExceptionCode code) {
      super(code.getMessage());
      this.code = code;
    }
}
