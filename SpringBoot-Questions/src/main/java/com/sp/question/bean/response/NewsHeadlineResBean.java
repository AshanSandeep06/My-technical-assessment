package com.sp.question.bean.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NewsHeadlineResBean {
    private int newsId;
    private String newsHeadline;
}
