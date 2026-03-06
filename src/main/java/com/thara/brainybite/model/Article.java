package com.thara.brainybite.model;

import java.sql.Date;

public class Article {

    private int id;
    private String category;
    private String title;
    private String description;
    private String content;
    private String thumbnail_url;
    private Date published;

    public Article() {}

    public Article(String category, String title, String description, String content, String thumbnail_url){
        this.category = category;
        this.title = title;
        this.description = description;
        this.content = content;
        this.thumbnail_url = thumbnail_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }
}
