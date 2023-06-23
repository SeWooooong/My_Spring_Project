package com.example.my_spring_project.article.controller;

import com.example.my_spring_project.article.Article;
import com.example.my_spring_project.article.ArticleService;
import com.example.my_spring_project.article.dto.ArticleResponseDto.ArticleViewResponseDto;
import com.example.my_spring_project.article.dto.ArticleResponseDto.ArticleListViewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ArticleViewController {
    private final ArticleService articleService;

    @GetMapping("/articles")
    public String getArticles(Model model){
        List<ArticleListViewResponseDto> articles = articleService.findAll().stream()
                .map(ArticleListViewResponseDto::new)
                .toList();

        model.addAttribute("articles", articles);

        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model){
        Article article = articleService.findById(id);
        model.addAttribute("article", new ArticleViewResponseDto(article));

        return "article";
    }

    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model){
        if(id == null){
            model.addAttribute("article", new ArticleViewResponseDto());
        }else{
            Article article = articleService.findById(id);
            model.addAttribute("article", new ArticleViewResponseDto(article));
        }

        return "newArticle";
    }
}
