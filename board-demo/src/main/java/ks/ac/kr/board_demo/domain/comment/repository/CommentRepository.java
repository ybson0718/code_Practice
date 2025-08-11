package ks.ac.kr.board_demo.domain.comment.repository;

import ks.ac.kr.board_demo.domain.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentByPost_Id(Long postId);
}