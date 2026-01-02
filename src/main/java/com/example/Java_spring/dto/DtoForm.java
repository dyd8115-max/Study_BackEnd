package com.example.Java_spring.dto;

import com.example.Java_spring.entity.Sttu;
import lombok.AllArgsConstructor;
import lombok.ToString;


@ToString
@AllArgsConstructor
public class DtoForm {



    private String titles;
    private String author;






    public Sttu toEntity()
    {
        return new Sttu(null, titles, author);
    }

}
