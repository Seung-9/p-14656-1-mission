package com.back.domain.comment.service;

import com.back.domain.comment.document.Comment;
import com.back.domain.comment.repository.CommentRepository;
import com.back.domain.post.document.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public long count() {
        return commentRepository.count();
    }

    public Comment create(Post post, String content, String author) {
        return commentRepository.save(Comment.create(post.getId(), content, author));
    }
}
