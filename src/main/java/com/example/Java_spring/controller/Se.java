package com.example.Java_spring.controller;

import com.example.Java_spring.dto.DtoForm;
import com.example.Java_spring.entity.Sttu;
import com.example.Java_spring.repository.STY;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class Se {

    @Autowired
    private STY sty;

    @GetMapping("/Study")
    public String stu()
    {
        return "articles/study";
    }

    @PostMapping("/Study")
    public String Stu(DtoForm form)
    {
       log.info(form.toString());

        Sttu sttu=form.toEntity();
        log.info(sttu.toString());
        Sttu saved=sty.save(sttu);
        log.info(saved.toString());

        return "redirect:/Study";
    }



}
