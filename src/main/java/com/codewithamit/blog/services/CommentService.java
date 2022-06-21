package com.codewithamit.blog.services;

import com.codewithamit.blog.entities.Comment;
import com.codewithamit.blog.payloads.CommentsDto;

public interface CommentService {
    CommentsDto createComment(CommentsDto commentsDto, Integer postId);
    void deleteComment(Integer commentId);
}
