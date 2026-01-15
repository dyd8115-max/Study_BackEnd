package com.example.Java_spring.api;


import com.example.Java_spring.dto.ArticleForm;
import com.example.Java_spring.entity.Article;
import com.example.Java_spring.repository.ArticleRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
public class ArticleApiController {


    @Autowired
    private ArticleRepository articleRepository;


    @GetMapping("/api/articles")
    public Iterable<Article> index()
    {
        return articleRepository.findAll();
    }


    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id)
    {


        return articleRepository.findById(id).orElse(null);
    }

    @PostMapping("/api/articles")
    public Article create(@RequestBody ArticleForm dto)
    {
        Article article=dto.toEntity();

        return articleRepository.save(article);

    }


    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto)
    {
        Article article=dto.toEntity();
        log.info("id: {}, article: {}", id, article.toString());
        Article target=articleRepository.findById(id).orElse(null);
        if(target==null || id!=article.getId())
        {
            log.info("잘못된 요청");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Article updated=articleRepository.save(article);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
}
