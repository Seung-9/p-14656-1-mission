package com.back.domain.comment.repository;

import com.back.domain.comment.document.Comment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CommentRepository extends ElasticsearchRepository<Comment, String> {
}
