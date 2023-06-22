package com.example.my_spring_project.article.dto;

import com.example.my_spring_project.article.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


public class ArticleResponseDto {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class ArticleSelectDto{
        private String title;
        private String content;

        public ArticleSelectDto(Article article){
            this.title = article.getTitle();
            this.content = article.getContent();
        }
    }

    @NoArgsConstructor
    @Getter
    public static class ArticleViewResponseDto{
        private Long id;
        private String title;
        private String content;
        private LocalDateTime createdAt;

        public ArticleViewResponseDto(Article article){
            this.id = article.getId();
            this.title = article.getTitle();
            this.content = article.getContent();
            this.createdAt = article.getLocalDateTime();
        }
    }

    @AllArgsConstructor
    @Getter
    public static class ArticleListViewResponseDto{
        private final Long id;
        private final String title;
        private final String content;

        public ArticleListViewResponseDto(Article article){
            this.id = article.getId();
            this.title = article.getTitle();
            this.content = article.getContent();
        }
    }
}
