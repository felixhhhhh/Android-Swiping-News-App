package com.laioffer.newsapp.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.laioffer.newsapp.model.Article;

// version specifies a current version. once introduce or modify, increase the version and define migration strategy
@Database(entities = {Article.class}, version = 1, exportSchema = false)
public abstract class TinNewsDatabase extends RoomDatabase {
    // both abstract because room annotation will process
    public abstract ArticleDao articleDao();

}
