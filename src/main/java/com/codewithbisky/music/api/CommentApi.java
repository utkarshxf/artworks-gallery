package com.codewithbisky.music.api;

import com.codewithbisky.music.model.Album;
import com.codewithbisky.music.model.Comment;
import com.codewithbisky.music.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentApi {

    private  final CommentService commentService;

    @PostMapping("/artwork/{artworkId}/user/{userId}")
    public ResponseEntity<Album> createNewComment(@RequestBody Comment comment, @PathVariable String artworkId, @PathVariable  String userId){

        commentService.create(comment,userId,artworkId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping("/{id}")
    public void deleteById( @PathVariable String id){

        commentService.deleteById(id);
    }

}
