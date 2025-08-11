package ks.ac.kr.board_demo.domain.member.controller;

import ks.ac.kr.board_demo.global.exception.dto.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberExceptionCode implements ExceptionCode {

    BAD_REQUEST_NO_INFO(4001, "필수 입력 정보가 없습니다."),
    UNAUTHORIZED_WRONG_PASSWORD(4011, "비밀번호가 일치하지 않습니다."),
    NOT_FOUND_USER_NAME(4041, "존재하지 않는 회원 id입니다."),
    BAD_REQUEST_NO_REFRESH(9001, "토큰이 없습니다."),
    UNAUTHORIZED_INVALID_FORMAT(8002, "유효하지 않은 토큰 형식입니다."),
    UNAUTHORIZED_EXPIRED(8003, "만료된 토큰입니다."),
    INTERNAL_SERVER_ERROR(5000, "서버에서 예기치 못한 오류가 발생했습니다."),

    ;

    private int code;
    private String message;

}
