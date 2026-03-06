package com.thara.brainybite.repository;

import com.thara.brainybite.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcArticleRepository implements ArticleRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Article findById(int id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM article WHERE id = ?",
                    new BeanPropertyRowMapper<>(Article.class), id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to Find Article: " + e.getMessage());
        }
    }

    @Override
    public List<Article> findAll() {
        try {
            String q = "SELECT * FROM article";
            return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Article.class));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to Find Article: " + e.getMessage());
        }

    }

    @Override
    public List<Article> findByCategory(String category) {
        try {
            String q = "SELECT * FROM article WHERE category = ?";
            return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Article.class), category);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to Find Article: " + e.getMessage());
        }
    }

    @Override
    public int insertArticle(Article article) {
        try {
            return jdbcTemplate.update("INSERT INTO article (`category`, `title`, `description`, `content`, `thumbnail_url`, `published`)" +
                            "VALUES (?, ?, ?, ?, ?, CURRENT_DATE())",
                    new Object[] {article.getCategory(), article.getTitle(), article.getDescription(), article.getContent(),
                            article.getThumbnail_url()});

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to Insert Article: " + e.getMessage());

        }
    }

    @Override
    public int deleteArticle(Article article) {
        try {
            String q = "DELETE FROM article WHERE id = ?";
            return jdbcTemplate.update(q, article.getId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to Delete Article: " + e.getMessage());
        }
    }
}
