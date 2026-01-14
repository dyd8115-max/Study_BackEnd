package com.example.Java_spring.repository;

import com.example.Java_spring.entity.ArticleStudy;
import org.springframework.data.repository.CrudRepository;

public interface StudyRepository extends CrudRepository<ArticleStudy, Long> {
}
