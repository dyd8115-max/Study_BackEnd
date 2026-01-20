package com.example.Java_spring.api;


import com.example.Java_spring.dto.ArticleForm;
import com.example.Java_spring.entity.Article;
import com.example.Java_spring.repository.ArticleRepository;
import com.example.Java_spring.service.ArticleService;
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
    private ArticleService articleService;

    @GetMapping("/api/articles")
    public Iterable<Article> index()
    {
        return articleService.index();
    }

    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id)
    {


        return articleService.show(id);
    }

    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto)
    {
        Article created=articleService.create(dto);

        return (created!=null)?
                ResponseEntity.status(HttpStatus.OK).body(created):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();


    }

    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {

        Article updated=articleService.update(id,dto);
        return (updated!=null)?
                ResponseEntity.status(HttpStatus.OK).body(updated):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id)
    {
        Article deleted=articleService.delete(id);

       return (deleted!=null)?
               ResponseEntity.status(HttpStatus.NO_CONTENT).build():
               ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }


    @PostMapping("api/transaction-test")
    public ResponseEntity<List<Article>> transactionTest(@RequestBody List<ArticleForm> dtos){
        List<Article> createdList=articleService.createArticles(dtos);
        return (createdList!=null)?
                ResponseEntity.status(HttpStatus.OK).body(createdList):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();


    }


//    private ArticleRepository articleRepository;
//
//
//    @GetMapping("/api/articles")
//    public Iterable<Article> index()
//    {
//        return articleRepository.findAll();
//    }
//
//
//    @GetMapping("/api/articles/{id}")
//    public Article show(@PathVariable Long id)
//    {
//
//
//        return articleRepository.findById(id).orElse(null);
//    }
//
//    @PostMapping("/api/articles")
//    public Article create(@RequestBody ArticleForm dto)
//    {
//        Article article=dto.toEntity();
//
//        return articleRepository.save(article);
//
//    }
//
//
//    @PatchMapping("/api/articles/{id}")
//    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto)
//    {
//        Article article=dto.toEntity();
//        log.info("id: {}, article: {}", id, article.toString());
//        Article target=articleRepository.findById(id).orElse(null);
//        if(target==null || id!=article.getId())
//        {
//            log.info("잘못된 요청");
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//
//
//        target.patch(article);
//        Article update =articleRepository.save(target);
//        return ResponseEntity.status(HttpStatus.OK).body(update);
//    }
//
//    @DeleteMapping("/api/articles/{id}")
//    public ResponseEntity<Article> delete(@PathVariable Long id)
//    {
//        Article target=articleRepository.findById(id).orElse(null);
//        if(target==null)
//        {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//
//        articleRepository.delete(target);
//        return ResponseEntity.status(200).body(null);
//    }
}
