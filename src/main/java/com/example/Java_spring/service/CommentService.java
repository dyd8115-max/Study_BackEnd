package com.example.Java_spring.service;


import com.example.Java_spring.dto.CommentDto;
import com.example.Java_spring.entity.Comment;
import com.example.Java_spring.repository.ArticleRepository;
import com.example.Java_spring.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleRepository articleRepository;


    public List<CommentDto> comments(Long articleId) {
        List<Comment> comments=commentRepository.findByArticleId(articleId);

        List<CommentDto> dtos = new ArrayList<CommentDto>();

//        for(int i=0; i<comments.size(); i++)
//        {
//            Comment c=comments.get(i);
//            CommentDto dto=CommentDto.createCommentDto(c);
//            dtos.add(dto);
//        }


//        return dtos;
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }
}
