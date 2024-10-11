package com.sp.question.bean.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NewsResponseBean {
    private int id;
    private String content;
    private String headLine;
    private LocalDateTime publishedAt;
}
