package com.sp.question.bean.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NewsHeadlinesReqBean {
    private int newsId;
    private String newsHeadline;
}
