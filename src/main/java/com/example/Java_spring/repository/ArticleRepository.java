package com.example.Java_spring.repository;

import com.example.Java_spring.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

    @Override
    Iterable<Article> findAll();
}
