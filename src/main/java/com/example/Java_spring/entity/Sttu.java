package com.example.Java_spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.ToString;


@Entity
@AllArgsConstructor
@ToString
public class Sttu {
    @Id
    @GeneratedValue
    public Long Id;

    @Column
    public String titles;
    @Column
    public String author;







}
