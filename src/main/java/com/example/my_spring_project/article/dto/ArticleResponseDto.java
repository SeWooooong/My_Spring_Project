package com.example.my_spring_project.article.dto;

import com.example.my_spring_project.article.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ArticleResponseDto {
    private String title;
    private String content;

    public ArticleResponseDto(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
