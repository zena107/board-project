package com.fastcampus.boardproject.domain;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
@Getter
@ToString
//@Table(indexes = {})
public class ArticleComment {
    private Long id;
    private Article article_id;
    private String content;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;
}
