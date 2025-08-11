package ks.ac.kr.board_demo.domain.post.controller;

import ks.ac.kr.board_demo.global.exception.dto.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PostExceptionCode implements ExceptionCode {
    BAD_REQUEST_MISSING_FIELD(4001, "필수 입력 정보가 없습니다."),
    UNAUTHORIZED_LOGOUT_USER_(4012, "로그인한 사용자만 게시글을 작성할 수 있습니다."),
    NOT_FOUND_USERID(4041, "존재하지 않는 회원 id입니다."),
    NOT_FOUND_POSTID(4042, "존재하지 않는 게시글입니다.")
    ;

    private int code;
    private String message;}
