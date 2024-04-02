package com.rest.practice.domain.article.service;

import com.rest.practice.domain.article.entity.Article;
import com.rest.practice.domain.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getArticleList() {
        return this.articleRepository.findAll();
    }

    public Optional<Article> getArticleById(Long id) {
        return this.articleRepository.findById(id);
    }

//    public void delete(Long id) {
//        this.articleRepository.delete(article);
//    }

    public Article create(String title, String content) {
        Article article = Article.builder()
                .title(title)
                .content(content)
                .build();
        return this.articleRepository.save(article);
    }
}
