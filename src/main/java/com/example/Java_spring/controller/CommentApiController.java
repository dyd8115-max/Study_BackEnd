package com.example.Java_spring.controller;


import com.example.Java_spring.dto.CommentDto;
import com.example.Java_spring.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentApiController {


    @Autowired
    private CommentService commentService;

    @GetMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<List<CommentDto>> comments(@PathVariable Long articleId)
    {
        List<CommentDto> dtos=commentService.comments(articleId);

        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

}
