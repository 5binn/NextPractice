package com.rest.practice.domain.article.controller;

import com.rest.practice.domain.article.entity.Article;
import com.rest.practice.domain.article.service.ArticleService;
import com.rest.practice.global.rsData.RsData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //문자열로 리턴
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ApiV1ArticleController {
    private final ArticleService articleService;


    @AllArgsConstructor
    @Getter
    public static class ArticleListResponse {
        private final List<Article> articleList;
    }

    @GetMapping("")
    public RsData<ArticleListResponse> getArticles() {
        List<Article> articleList = this.articleService.getArticleList();
        return RsData.of("S-1", "성공", new ArticleListResponse(articleList));
    }

    @AllArgsConstructor
    @Getter
    public static class ArticleResponse {
        private final Article article;
    }

    @GetMapping("/{id}")
    public RsData<ArticleResponse> getArticle(@PathVariable("id") Long id) {
        return articleService.getArticleById(id)
                .map((article) -> RsData.of(
                "S-1",
                "성공",
                new ArticleResponse(article)
        )).orElseGet(() -> RsData.of(
                "F-1",
                "%d 번 게시물 없음".formatted(id),
                null
        ));
    }

    @PostMapping("")
    public String createArticle() {
        return "저장 완료";
    }

    @DeleteMapping("/{id}")
    public String deleteArticle(@PathVariable("id") Long id) {
        return id + " 번 삭제 완료";
    }
}
