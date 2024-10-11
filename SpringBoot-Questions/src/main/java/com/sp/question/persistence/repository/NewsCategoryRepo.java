package com.sp.question.persistence.repository;

import com.sp.question.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsCategoryRepo extends JpaRepository<CategoryEntity, Integer> {
}
