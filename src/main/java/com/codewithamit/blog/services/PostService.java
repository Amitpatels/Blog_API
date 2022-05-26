package com.codewithamit.blog.services;

import com.codewithamit.blog.entities.Post;
import com.codewithamit.blog.payloads.PostDto;
import com.codewithamit.blog.payloads.PostResponse;

import java.util.List;

public interface PostService {

    //create
    PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);

    //update
    PostDto updatePost(PostDto postDto, Integer postId);

    //delete
    void deletePost(Integer postId);

    //get all posts
    PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy, String sortDir);

    //getSingle posts
    PostDto getPostById(Integer postId);

    //get all post by category
    List<PostDto> getPostByCategory(Integer categoryId);

    //get all post by category
    List<PostDto> getPostsByUser(Integer userId);

    //search posts
    List<PostDto> searchPost(String keyword);

}
