package com.sp.question.persistence.repository;

import com.sp.question.persistence.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<CommentEntity, Integer> {
    List<CommentEntity> findByNewsId(int newsId);
}
