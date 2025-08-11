package ks.ac.kr.board_demo.domain.comment.controller;

import ks.ac.kr.board_demo.global.response.SuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommentSuccessCode implements SuccessCode {

    OK_COMMENT_WRITTEN(2201, "댓글 작성에 성공했습니다."),
    ;

    final int code;
    final String message;

}