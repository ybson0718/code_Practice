package ks.ac.kr.board_demo.domain.comment.controller;

import ks.ac.kr.board_demo.domain.comment.dto.CommentRequest;
import ks.ac.kr.board_demo.domain.comment.service.CommentService;
import ks.ac.kr.board_demo.global.response.BoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/write")
    public BoardResponse<Void> createComment(
            @RequestHeader("Authorization") String username,
            @RequestBody CommentRequest req
    ) {
        commentService.createComment(username, req.postId(), req.content());
        return BoardResponse.of(CommentSuccessCode.OK_COMMENT_WRITTEN);
    }

}