package com.example.Java_spring.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Article {
    //엔티티

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;

    @Column
    private String title;
    @Column
    private String content;





}
