package com.example.Java_spring.entity;


import com.example.Java_spring.dto.CommentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="article_id")
    private Article article;

    @Column
    private String nickname;

    @Column
    private String body;


    public static Comment createComment(CommentDto dto, Article article) {

        if(dto.getId()!=null)
        {
            throw new IllegalArgumentException("생성 실패");
        }

        if(dto.getArticleId()!=article.getId())
        {
            throw new IllegalArgumentException("생성 실패");
        }

        return new Comment(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody()
        );
    }
}
