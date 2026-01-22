package com.example.Java_spring.dto;


import com.example.Java_spring.entity.Comment;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class CommentDto {

    private Long Id;
    private Long articleId;
    private String nickname;
    private String body;

    public static CommentDto createCommentDto(Comment comment) {

        return new CommentDto(
                comment.getId(),
                comment.getArticle().getId(),
                comment.getNickname(),
                comment.getBody()
        );
    }
}
