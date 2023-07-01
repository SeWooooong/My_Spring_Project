package com.example.my_spring_project.article.dto;

import com.example.my_spring_project.article.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class ArticleRequestDto {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class ArticleinsertDto {
        private String title;
        private String content;
        public Article toEntity(String author) {
            return Article.builder()
                    .title(title)
                    .content(content)
                    .author(author)
                    .build();
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class ArticleUpdateDto{
        private String title;
        private String content;
    }
    
}
