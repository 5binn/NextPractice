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

    public Article getArticleById(Long id) {
        Optional<Article> article = this.articleRepository.findById(id);
        if (article.isEmpty()) {
            return null;
        }
        return article.get();
    }


    public void deleteArticle(Long id) {
        Article article = this.getArticleById(id);
        this.articleRepository.delete(article);
    }

    public void create(String title, String content) {
        Article article = Article.builder()
                .title(title)
                .content(content)
                .build();
        this.articleRepository.save(article);
    }
}
