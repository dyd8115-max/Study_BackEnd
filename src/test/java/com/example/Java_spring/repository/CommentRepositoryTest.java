package com.example.Java_spring.repository;

import com.example.Java_spring.entity.Article;
import com.example.Java_spring.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;


    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {

//        Long articleId=4L;
//
//        List<Comment> comments=comments=commentRepository.findByArticleId(articleId);
//
//        Article article=new Article(4L, "좋아하는 영화", "ㅈㄱㄴ");
//
//        Comment a=new Comment(1L, article, "a", "아이언맨3");
//        Comment b=new Comment(2L, article, "b", "극한직업");
//
//        List<Comment> expected= Arrays.asList(a,b);
//
//        assertEquals(expected.toString(), comments.toString(), "댓글 출력");

        Long articleId=1L;

        List<Comment> comments=commentRepository.findByArticleId(articleId);

        Article article=new Article(4L, "좋아하는 영화", "ㅈㄱㄴ");
        List<Comment> expected=Arrays.asList();

        assertEquals(expected.toString(), comments.toString(), "1번댓글이 없음");
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {

        String nickname="a";

        List<Comment> comments=commentRepository.findByNickname(nickname);

        Comment a=new Comment(1L, new Article(4L, "좋아하는 영화", "ㅈㄱㄴ"),
        nickname, "아이언맨3");

        Comment b=new Comment(3L, new Article(5L, "좋아하는 동물", "ㅈㄱㄴ"),
                nickname, "강아지");

        Comment c=new Comment(8L, new Article(6L, "좋아하는 음식", "ㅈㄱㄴ"),
                nickname, "피자");

        List<Comment> expected=Arrays.asList(a, b, c);
        assertEquals(expected.toString(), comments.toString(), "댓글출력");
    }
}