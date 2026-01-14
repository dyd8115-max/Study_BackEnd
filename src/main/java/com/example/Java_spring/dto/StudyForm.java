package com.example.Java_spring.dto;


import com.example.Java_spring.entity.ArticleStudy;

import com.example.Java_spring.entity.Article;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



//dto
@NoArgsConstructor
@AllArgsConstructor//생성자 롬복
@ToString//투스트링 룸복
@Setter
public class StudyForm {

    //필드
    private String school;
    private String name;
    private int number;




    public ArticleStudy toEntity()//엔티티 생성
    {
        return new ArticleStudy(null, school, name, number);
    }


}
