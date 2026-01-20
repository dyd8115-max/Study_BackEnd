package com.example.Java_spring.service;

import com.example.Java_spring.dto.ArticleForm;
import com.example.Java_spring.entity.Article;
import com.example.Java_spring.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Iterable<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        Article article=dto.toEntity();

        if(article.getId()!=null)
        {
            return null;
        }

        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {
        Article article=dto.toEntity();
        log.info("id: {}, article: {}", id, article.toString());
        Article target=articleRepository.findById(id).orElse(null);
        if(target==null || id!=article.getId())
        {
            log.info("잘못된 요청");
            return null;
        }


        target.patch(article);
        Article update =articleRepository.save(target);
        return update;
    }

    public Article delete(Long id) {

        Article target=articleRepository.findById(id).orElse(null);
        if(target==null)
        {
            return null;
        }

        articleRepository.delete(target);
        return target;
    }

    @Transactional
    public List<Article> createArticles(List<ArticleForm> dtos) {
        List<Article> articleList=dtos.stream()
                .map(dto->dto.toEntity())
                .collect(Collectors.toList());
        articleList.stream()
                .forEach(article -> articleRepository.save(article));
        articleRepository.findById(-1L)
                .orElseThrow(()->new IllegalArgumentException("결제 실패"));
        return articleList;
    }
}
