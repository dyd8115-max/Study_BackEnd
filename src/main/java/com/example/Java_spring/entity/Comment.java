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

    public void patch(CommentDto dto) {
        // 1. ID 예외 처리 (수정하려는 대상과 데이터의 ID가 일치하는지 확인)
        if (dto.getId() != null && !this.id.equals(dto.getId())) {
            throw new IllegalArgumentException("댓글 수정 실패: 잘못된 ID가 입력되었습니다.");
        }

        // 2. 내용 갱신 (기존 로직 유지)
        if (dto.getNickname() != null)
            this.nickname = dto.getNickname();
        if (dto.getBody() != null)
            this.body = dto.getBody();
    }
}
