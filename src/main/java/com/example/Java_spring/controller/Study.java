    package com.example.Java_spring.controller;


    import com.example.Java_spring.dto.StudyForm;
    import com.example.Java_spring.entity.Article;
    import com.example.Java_spring.entity.ArticleStudy;
    import com.example.Java_spring.repository.ArticleRepository;
    import com.example.Java_spring.repository.StudyRepository;
    import lombok.Getter;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;

    import java.util.List;
    import java.util.Optional;

    @Slf4j//log.info 사용가능
    @Controller
    public class Study {

        @Autowired//따로 객체셍성없이 사용가능(의존성 주입)
        private StudyRepository studyRepostory; //


        @GetMapping("/Study/New")//조회
        public String NewStudy(Model model)//메인창
        {
            return "articles/StudyInput" ; //프론트로 이동
        }

        @PostMapping("/Study/Create")//생성
        public String CrateStudy(StudyForm form)
        {

            ArticleStudy article=form.toEntity();//엔티티 생성

            ArticleStudy saved=studyRepostory.save(article);//리포지토리 저장
            return "redirect:/Study/" + saved.getId();
        }

        @GetMapping("/Study/{id}")
        public String show(@PathVariable Long id, Model model)//id 모델
        {

            ArticleStudy articleStudy=studyRepostory.findById(id).orElse(null);//찾은 값이 있으면 저장 없으면 null

            model.addAttribute("article", articleStudy);

            return "articles/StudyShow";
        }

        @GetMapping("/Study/List")
        public String List(Model model)
        {
            Iterable<ArticleStudy> articleStudyList=studyRepostory.findAll();

            model.addAttribute("articleList", articleStudyList);

            return "/articles/StudyListAll";
        }




    }
