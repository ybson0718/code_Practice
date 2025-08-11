package ks.ac.kr.board_demo.domain.post.controller;

import ks.ac.kr.board_demo.global.response.SuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum PostSuccessCode implements SuccessCode {

    GENERATED_POST(2101, "게시글 작성에 성공했습니다."),
    OK_GET_ALL_POSTS(2102, "게시글 목록 조회에 성공습니다."),
    OK_GET_POST(2103, "게시글 조회에 성공했습니다."),
    ;


    private int code;
    private String message;
}
