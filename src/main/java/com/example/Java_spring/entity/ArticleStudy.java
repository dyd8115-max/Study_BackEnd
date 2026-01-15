package com.example.Java_spring.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity//엔티티
@NoArgsConstructor//기본생성자 룸복
@AllArgsConstructor//생성자 롬복
@ToString//투스트링 롬복
@Getter//GetId사용가능
public class ArticleStudy {

    @Id//판단번호
    @GeneratedValue(strategy = GenerationType.IDENTITY)//번호 자동생성
    private Long id;


    @Column//테이블 열로 저장
    private String school;

    @Column
    private String name;

    @Column
    private int number;




}
