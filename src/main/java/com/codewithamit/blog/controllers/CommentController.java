package com.codewithamit.blog.controllers;

import com.codewithamit.blog.payloads.ApiResponse;
import com.codewithamit.blog.payloads.CommentsDto;
import com.codewithamit.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comment")
    public ResponseEntity<CommentsDto> createComment(@RequestBody CommentsDto commentDto, @PathVariable Integer postId){
        CommentsDto commentCreated = this.commentService.createComment(commentDto, postId);
        return new ResponseEntity<CommentsDto>(commentCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted sucessfully",true),HttpStatus.OK);
    }


}
