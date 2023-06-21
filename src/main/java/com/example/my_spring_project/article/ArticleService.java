package com.example.my_spring_project.article;

import com.example.my_spring_project.article.dto.ArticleRequestDto.ArticleinsertDto;
import com.example.my_spring_project.article.dto.ArticleRequestDto.ArticleUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    public Article save(ArticleinsertDto requestDto){
        return articleRepository.save(requestDto.toEntity());
    }

    public List<Article> findAll(){
        return articleRepository.findAll();
    }

    public Article findById(long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id) {
        articleRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, ArticleUpdateDto articleUpdateDto){
       Article article = articleRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

       article.update(articleUpdateDto.getTitle(), articleUpdateDto.getContent());
       return article;
    }
}
