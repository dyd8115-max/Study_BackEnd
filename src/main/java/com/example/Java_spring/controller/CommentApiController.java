package com.example.Java_spring.controller;


import com.example.Java_spring.dto.CommentDto;
import com.example.Java_spring.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<CommentDto> create(@PathVariable Long articleId, @RequestBody CommentDto dto)
    {
        CommentDto createdDto=commentService.create(articleId, dto);

        return ResponseEntity.status(HttpStatus.OK).body(createdDto);


    }


    @PatchMapping("/api/comments/{id}")
    public ResponseEntity<CommentDto> update(@PathVariable Long id, @RequestBody CommentDto dto)
    {
        CommentDto updateDto =commentService.update(id, dto);

        return ResponseEntity.status(HttpStatus.OK).body(updateDto);
    }

}
