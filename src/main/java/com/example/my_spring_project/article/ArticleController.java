package com.example.my_spring_project.article;

import com.example.my_spring_project.article.dto.ArticleResponseDto.ArticleSelectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.my_spring_project.article.dto.ArticleRequestDto.ArticleinsertDto;
import com.example.my_spring_project.article.dto.ArticleRequestDto.ArticleUpdateDto;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody ArticleinsertDto request){
        Article savedArticle = articleService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleSelectDto>> findAllArticles() {
        List<ArticleSelectDto> articles = articleService.findAll().stream()
                .map(ArticleSelectDto::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleSelectDto> findArticle(@PathVariable long id) {
        Article article = articleService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleSelectDto(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id){
        articleService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id,
                                                 @RequestBody ArticleUpdateDto request){
        Article updateArticle = articleService.update(id, request);

        return ResponseEntity.ok()
                .body(updateArticle);
    }

}
