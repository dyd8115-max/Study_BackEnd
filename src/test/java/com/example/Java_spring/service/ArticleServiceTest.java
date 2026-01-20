    package com.example.Java_spring.service;

    import com.example.Java_spring.dto.ArticleForm;
    import com.example.Java_spring.entity.Article;
    import org.junit.jupiter.api.Test;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.transaction.annotation.Transactional;

    import java.util.Arrays;
    import java.util.ArrayList;
    import java.util.List;

    import static org.junit.jupiter.api.Assertions.*;

    @SpringBootTest
    class ArticleServiceTest {

        @Autowired
        ArticleService articleService;

        @Test
        void index() {

            Iterable<Article> articles=articleService.index();

            Article a=new Article(1L, "강아지", "멍멍");
            Article b=new Article(2L, "고양이", "야옹");
            Article c=new Article(3L, "병아리", "삐약");

            List<Article> expected=new ArrayList<Article>(Arrays.asList(a,b,c));

            assertEquals(expected.toString(), articles.toString());


        }

        @Test
        void show_성공() {

            Long id=1L;
            Article expected=new Article(id, "강아지", "멍멍");

            Article article=articleService.show(id);

            assertEquals(expected.toString(), article.toString());
        }

        @Test
        void show_실패() {

            Long id=-1L;
            Article expected=null;

            Article article=articleService.show(id);

            assertEquals(expected, article);
        }

        @Test
        @Transactional
        void create_성공() {

            String title= "소";
            String content="음메";
            ArticleForm dto=new ArticleForm(title, content, null);
            Article expected=new Article(4L, title, content);
            Article article=articleService.create(dto);

            assertEquals(expected.toString(), article.toString());
        }

        @Test
        @Transactional
        void create_실패() {

            Long id=4L;
            String title= "소";
            String content="음메";
            ArticleForm dto=new ArticleForm(title, content,id);
            Article expected=null;
            Article article=articleService.create(dto);

            assertEquals(expected, article);
        }


    }