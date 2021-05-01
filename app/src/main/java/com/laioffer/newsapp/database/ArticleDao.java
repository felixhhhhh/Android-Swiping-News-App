package com.project.newsapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.laioffer.newsapp.model.Article;

import java.util.List;

//Dao: Query, Insert, Delete
@Dao
public interface ArticleDao {

    @Insert
    void saveArticle(Article article);

    @Query("SELECT * FROM article")
    LiveData<List<Article>> getAllArticles();

    @Delete
    void deleteArticle(Article article);
}

