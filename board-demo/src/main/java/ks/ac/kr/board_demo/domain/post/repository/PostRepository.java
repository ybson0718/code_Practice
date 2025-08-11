package ks.ac.kr.board_demo.domain.post.repository;

import ks.ac.kr.board_demo.domain.member.model.Member;
import ks.ac.kr.board_demo.domain.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
