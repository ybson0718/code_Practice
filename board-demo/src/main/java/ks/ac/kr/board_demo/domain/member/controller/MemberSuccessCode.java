package ks.ac.kr.board_demo.domain.member.controller;

import ks.ac.kr.board_demo.global.response.SuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberSuccessCode implements SuccessCode {

    OK_REGISTERED_MEMBER(2001, "회원가입이 완료됐습니다."),
    OK_LOGGED_IN(2002, "로그인에 성공했습니다."),
    OK_WITHDRAWAL_MEMBER(2003, "회원탈퇴에 성공했습니다."),
    OK_TOKEN_REISSUED(2005, "토큰 재발급에 성공했습니다."),


    ;

    private int code;
    private String message;
}
