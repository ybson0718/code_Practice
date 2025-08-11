package ks.ac.kr.board_demo.domain.comment.controller;

import ks.ac.kr.board_demo.global.exception.dto.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommentExceptionCode implements ExceptionCode {

    UNAUTHORIZED_NOT_LOGIN_USER(4013, "로그인한 사용자만 댓글을 작성할 수 있습니다."),
    NOT_FOUND_USER_ID(4041, "존재하지 않는 유저 id 입니다."),
    NOT_FOUND_POST_ID(4042, "존재하지 않는 게시글입니다."),
    ;

    final private int code;
    final private String message;

}