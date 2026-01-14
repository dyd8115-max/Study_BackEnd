package com.example.Java_spring.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity//엔티티
@NoArgsConstructor
@AllArgsConstructor//생성자 롬복
@ToString//투스트링 롬복
@Getter
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
