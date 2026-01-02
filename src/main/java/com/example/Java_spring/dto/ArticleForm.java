package com.example.Java_spring.dto;

import com.example.Java_spring.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;


@AllArgsConstructor //간소화
@ToString
public class ArticleForm {
    private String title;
    private String content;
    private Long id;



    public Article toEntity()//엔티티 변환
    {
        return new Article(id, title, content);
    }
}
