package ks.ac.kr.board_demo.global.response;

import jakarta.annotation.Nullable;

public record BoardResponse<T>(
        int code,
        String message,
        @Nullable T data
) {
    public static <T> BoardResponse<T> of(SuccessCode successCode){
        return new BoardResponse<T>(successCode.getCode(), successCode.getMessage(), null);
    }

    public static <T> BoardResponse<T> of(SuccessCode successCode, T data){
        return new BoardResponse<T>(successCode.getCode(), successCode.getMessage(), data);
    }
}
