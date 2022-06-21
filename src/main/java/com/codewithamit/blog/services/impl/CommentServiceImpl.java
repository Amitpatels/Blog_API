package com.codewithamit.blog.services.impl;

import com.codewithamit.blog.entities.Comment;
import com.codewithamit.blog.entities.Post;
import com.codewithamit.blog.exceptions.ResourceNotFoundException;
import com.codewithamit.blog.payloads.CommentsDto;
import com.codewithamit.blog.repositories.CommentRepository;
import com.codewithamit.blog.repositories.PostRepository;
import com.codewithamit.blog.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentsDto createComment(CommentsDto commentsDto, Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post","post id",postId));
        Comment comment = this.modelMapper.map(commentsDto,Comment.class);
        comment.setPost(post);
        Comment savedComment = this.commentRepository.save(comment);

        return this.modelMapper.map(savedComment,CommentsDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepository.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment","comment id",commentId));
    }
}
