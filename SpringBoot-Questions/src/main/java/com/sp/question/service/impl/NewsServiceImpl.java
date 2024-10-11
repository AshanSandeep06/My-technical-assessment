package com.sp.question.service.impl;

import com.sp.question.bean.response.NewsHeadlineResBean;
import com.sp.question.bean.response.NewsResponseBean;
import com.sp.question.persistence.entity.CategoryEntity;
import com.sp.question.persistence.entity.CommentEntity;
import com.sp.question.persistence.entity.NewsEntity;
import com.sp.question.persistence.repository.CommentRepo;
import com.sp.question.persistence.repository.NewsCategoryRepo;
import com.sp.question.persistence.repository.NewsRepo;
import com.sp.question.service.NewsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepo newsRepo;
    private final NewsCategoryRepo newsCategoryRepo;
    private final CommentRepo commentRepo;

    @Override
    public CategoryEntity addCategory(CategoryEntity category) {
        return newsCategoryRepo.save(category);
    }

    @Override
    public NewsEntity addNews(NewsEntity news) {
        news.setPublishedAt(LocalDateTime.now());
        return newsRepo.save(news);
    }

    @Override
    public List<NewsHeadlineResBean> getNewsHeadlinesWithIdsByCategory(int categoryId) {
        List<NewsEntity> newsList = newsRepo.findByCategories_Id(categoryId);
        return newsList.stream()
                .map(news -> new NewsHeadlineResBean(news.getId(), news.getHeadLine()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<NewsResponseBean> getNewsByIdAndHeadline(int id, String headline) {
        return newsRepo.findById(id)
                .filter(news -> news.getHeadLine().equals(headline))
                .map(news -> new NewsResponseBean(news.getId(), news.getContent(), news.getHeadLine(), news.getPublishedAt()));
    }

    @Override
    // Method to get a news item by ID
    public NewsEntity getNewsById(int id) {
        return newsRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("News not found"));
    }

    @Override
    // Method to add a Comment to a News item
    public void addComment(int newsId, CommentEntity comment) {
        NewsEntity news = getNewsById(newsId);
        comment.setNews(news);
        comment.setCreatedAt(LocalDateTime.now());
        commentRepo.save(comment);
    }
}
