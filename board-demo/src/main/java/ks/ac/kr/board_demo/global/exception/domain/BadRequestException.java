package ks.ac.kr.board_demo.global.exception.domain;

import ks.ac.kr.board_demo.global.exception.dto.ExceptionCode;
import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {

    private final ExceptionCode code;

    public BadRequestException(ExceptionCode code) {
        super(code.getMessage());
        this.code = code;
    }
}
