package com.codewithbisky.music.service;

import com.codewithbisky.music.model.Comment;

public interface CommentService {

    Comment create(Comment comment,String userId,String artworkId);
    Comment update(String id,Comment comment );

    void deleteById(String id);
}
