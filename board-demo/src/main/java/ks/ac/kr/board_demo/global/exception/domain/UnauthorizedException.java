package ks.ac.kr.board_demo.global.exception.domain;

import ks.ac.kr.board_demo.global.exception.dto.ExceptionCode;
import lombok.Getter;

@Getter
public class UnauthorizedException extends RuntimeException {

    ExceptionCode code;

    public UnauthorizedException(ExceptionCode code) {
        super(code.getMessage());
        this.code = code;
    }
}
