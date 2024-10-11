package com.sp.question.persistence.repository;

import com.sp.question.persistence.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepo extends JpaRepository<NewsEntity, Integer> {
    List<NewsEntity> findByCategories_Id(int categories_id);
}
