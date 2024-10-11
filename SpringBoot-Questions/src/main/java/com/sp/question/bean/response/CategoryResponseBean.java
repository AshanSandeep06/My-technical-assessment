package com.sp.question.bean.response;

import com.sp.question.persistence.entity.NewsEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CategoryResponseBean {
    private int id;
    private String categoryName;
    private List<NewsResponseBean> newsList;
}
