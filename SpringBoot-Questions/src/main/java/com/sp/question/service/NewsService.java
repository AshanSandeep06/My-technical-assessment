package com.sp.question.service;

import com.sp.question.bean.response.NewsHeadlineResBean;
import com.sp.question.bean.response.NewsResponseBean;
import com.sp.question.persistence.entity.CategoryEntity;
import com.sp.question.persistence.entity.CommentEntity;
import com.sp.question.persistence.entity.NewsEntity;

import java.util.List;
import java.util.Optional;

public interface NewsService {
    CategoryEntity addCategory(CategoryEntity category);

    NewsEntity addNews(NewsEntity news);

    List<NewsHeadlineResBean> getNewsHeadlinesWithIdsByCategory(int categoryId);

    Optional<NewsResponseBean> getNewsByIdAndHeadline(int id, String title);

    NewsEntity getNewsById(int id);

    void addComment(int newsId, CommentEntity comment);
}
