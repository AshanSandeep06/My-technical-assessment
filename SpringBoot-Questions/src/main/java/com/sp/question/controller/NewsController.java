package com.sp.question.controller;

import com.sp.question.bean.response.NewsHeadlineResBean;
import com.sp.question.bean.response.NewsResponseBean;
import com.sp.question.persistence.entity.CategoryEntity;
import com.sp.question.persistence.entity.CommentEntity;
import com.sp.question.persistence.entity.NewsEntity;
import com.sp.question.service.NewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/news", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@RequiredArgsConstructor
@Validated
@Slf4j
public class NewsController {
    private final NewsService newsService;

    @PostMapping("/createCategory")
    public ResponseEntity<CategoryEntity> saveCategory(@RequestBody CategoryEntity category) {
        CategoryEntity savedCategory = newsService.addCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @PostMapping("/createNews")
    public ResponseEntity<NewsEntity> saveNews(@RequestBody NewsEntity news) {
        NewsEntity savedNews = newsService.addNews(news);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNews);
    }

    @GetMapping("/categories/{categoryId}/newsHeadlines")
    public ResponseEntity<List<NewsHeadlineResBean>> getNewsByCategory(@PathVariable int categoryId) {
        List<NewsHeadlineResBean> newsHeadlines = newsService.getNewsHeadlinesWithIdsByCategory(categoryId);
        return ResponseEntity.ok(newsHeadlines);
    }

    @GetMapping("/getNews/{id}/title/{headline}")
    public ResponseEntity<NewsResponseBean> getNewsByIdAndHeadline(@PathVariable int id, @PathVariable String headline) {
        return newsService.getNewsByIdAndHeadline(id, headline)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{newsId}/addComment")
    public ResponseEntity<Void> addComment(@PathVariable int newsId, @RequestBody CommentEntity comment) {
        newsService.addComment(newsId, comment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/news/{id}")
    public ResponseEntity<NewsEntity> getNewsById(@PathVariable int id) {
        NewsEntity news = newsService.getNewsById(id);
        return ResponseEntity.ok(news);
    }
}
