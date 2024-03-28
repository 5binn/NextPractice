package com.rest.practice.domain.article.controller;

import com.rest.practice.domain.article.entity.Article;
import com.rest.practice.domain.article.service.ArticleService;
import com.rest.practice.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //문자열로 리턴
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ApiV1ArticleController {
    private final ArticleService articleService;

    @GetMapping("")
    public RsData<List<Article>> getArticles() {
        return RsData.of("S-1", "성공", this.articleService.getArticleList());
    }

    @GetMapping("/{id}")
    public RsData<Article> getArticle(@PathVariable("id") Long id) {
        return RsData.of("S-1", "성공", this.articleService.getArticleById(id));
    }

    @PostMapping("")
    public String createArticle() {
        return "저장 완료";
    }

    @DeleteMapping("/{id}")
    public String deleteArticle(@PathVariable("id") Long id) {
        this.articleService.deleteArticle(id);
        return id + " 번 삭제 완료";
    }
}
