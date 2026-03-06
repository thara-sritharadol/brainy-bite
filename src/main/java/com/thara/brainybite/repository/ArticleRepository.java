package com.thara.brainybite.repository;

import com.thara.brainybite.model.Article;

import java.util.List;

public interface ArticleRepository {

    Article findById(int id);
    List<Article> findAll();
    List<Article> findByCategory(String category);
    int insertArticle(Article article);
    int deleteArticle(Article article);

}
