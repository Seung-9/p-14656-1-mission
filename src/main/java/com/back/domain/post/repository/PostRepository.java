package com.back.domain.post.repository;

import com.back.domain.post.document.Post;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends ElasticsearchRepository<Post, String> {
    List<Post> findAll(); // ElasticSearch에서 findAll() 메서드는 Iterable<Post> 형태로 반환하기 때문
}