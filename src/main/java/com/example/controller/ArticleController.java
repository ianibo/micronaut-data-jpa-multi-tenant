package com.example.controller;

import java.util.Optional;

import com.example.entity.Article;
import com.example.repo.ArticleJpaRepo;
import com.example.repo.ArticleRepository;
import com.example.repo.MixedArticleRepo;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

/**
 * ArticleController.java
 *
 * Created on 13.08.2020
 *
 * @author Tariq Ahmed
 */
@Controller("/articles")
public class ArticleController {

    @Inject
    ArticleRepository repo;

    @Inject
    ArticleJpaRepo jpaRepo;

    @Inject
    MixedArticleRepo mixRepo;

    @Post
    public void createArticle(Article article) {
        repo.save(article);
    }

    @Get("/{articleId}")
    public Optional<Article> findArticle(Long articleId) {
        return repo.findById(articleId);
    }

    @Post("/em")
    public void createArticleEm(Article article) {
        jpaRepo.save(article);
    }

    @Get("/em/{articleId}")
    public Optional<Article> findArticleEm(Long articleId) {
        return jpaRepo.findById(articleId);
    }


    @Post("/mix")
    public void createArticleMix(Article article) {
        mixRepo.save(article);
    }

    @Get("/mix/{articleId}")
    public Optional<Article> findArticleMix(Long articleId) {
        return mixRepo.findById(articleId);
    }
}