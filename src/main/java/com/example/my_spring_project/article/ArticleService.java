package com.example.my_spring_project.article;

import com.example.my_spring_project.article.dto.ArticleRequestDto.ArticleinsertDto;
import com.example.my_spring_project.article.dto.ArticleRequestDto.ArticleUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    public Article save(ArticleinsertDto requestDto, String userName){
        return articleRepository.save(requestDto.toEntity(userName));
    }

    public List<Article> findAll(){
        return articleRepository.findAll();
    }

    public Article findById(long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id) {
        Article article = articleRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        authorizeArticleAuthor(article);
        articleRepository.delete(article);
    }

    @Transactional
    public Article update(long id, ArticleUpdateDto articleUpdateDto){
       Article article = articleRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

       authorizeArticleAuthor(article);
       article.update(articleUpdateDto.getTitle(), articleUpdateDto.getContent());
       return article;
    }

    // 게시글을 작성한 유저인지 확인
    private static void authorizeArticleAuthor(Article article){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if(!article.getAuthor().equals(userName)){
            throw new IllegalArgumentException("not authorized");
        }
    }
}
