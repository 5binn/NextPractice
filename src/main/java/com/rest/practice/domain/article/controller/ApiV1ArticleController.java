package com.rest.practice.domain.article.controller;

import com.rest.practice.domain.article.entity.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //문자열로 리턴
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ApiV1ArticleController {
    @GetMapping("")
    public List<Article> getArticles() {
        List<Article> articleList = new ArrayList<>();
        articleList.add(new Article(1L));
        articleList.add(new Article(2L));
        articleList.add(new Article(3L));
        return articleList;
    }

    @GetMapping("/{id}")
    public Article getArticle(@PathVariable("id") Long id) {
        return new Article(id);
    }

    @PostMapping("")
    public String createArticle(Long id) {
        try {
            Article article = new Article(id);
            return "저장 완료";
        } catch (IllegalArgumentException e) {
            return "실패: " + e.getMessage();
        }
    }
}
