package com.back.domain.post.service;

import com.back.domain.post.document.Post;
import com.back.domain.post.repository.PostRepository;
import com.back.global.exception.NotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public long count() {
        return postRepository.count();
    }

    public Post create(String title, String content, String author) {
        return postRepository.save(Post.create(title, content, author));
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Post not found id : " + id));
    }

    public Post update(String id, String title, String content) {
        Post post = findById(id);
        post.update(title, content);
        return postRepository.save(post);
    }

    public void delete(String id) {
        Post post = findById(id);
        postRepository.delete(post);
    }
}
