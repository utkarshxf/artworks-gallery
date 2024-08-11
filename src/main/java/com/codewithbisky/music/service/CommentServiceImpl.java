package com.codewithbisky.music.service;

import com.codewithbisky.music.model.Comment;
import com.codewithbisky.music.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@Slf4j
@RequiredArgsConstructor
public class CommentServiceImpl implements  CommentService{

    private final CommentRepository commentRepository;
    @Override
    public Comment create(Comment comment,String userId,String artworkId) {

        Comment comment1 = Comment.builder()
                .text(comment.getText())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .edited(false).build();

        Comment saved = commentRepository.save(comment1);
        commentRepository.addCommentRelationship(saved.getId(), artworkId,userId);


        return saved;
    }

    @Override
    public Comment update(String id, Comment comment) {


        return null;
    }

    @Override
    public void deleteById(String id) {
        commentRepository.deleteById(id);
    }
}
