package com.codewithamit.blog.controllers;

import com.codewithamit.blog.config.AppConstant;
import com.codewithamit.blog.payloads.ApiResponse;
import com.codewithamit.blog.payloads.PostDto;
import com.codewithamit.blog.payloads.PostResponse;
import com.codewithamit.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    //create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId){
        PostDto createdPost = this.postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);
    }

    //update
    @PutMapping("/post/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId){
        PostDto updatedPost = this.postService.updatePost(postDto,postId);
        return new ResponseEntity<PostDto>(updatedPost, HttpStatus.CREATED);
    }

    //get By user
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
        List<PostDto> posts = this.postService.getPostsByUser(userId);
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }

    //get post by category
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
        List<PostDto> posts = this.postService.getPostByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }

    //getAllPost
    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPost(
            @RequestParam(value="pageNumber", defaultValue = AppConstant.PAGE_NUMBER ,required = false) Integer pageNumber,
            @RequestParam(value="pageSize", defaultValue = AppConstant.PAGE_SIZE,required = false) Integer pageSize,
            @RequestParam(value="sortBy", defaultValue = AppConstant.SORT_BY, required = false) String sortBy,
            @RequestParam(value="sortDir", defaultValue = AppConstant.SORT_DIR, required = false) String sortDir
    ){
        PostResponse posts = this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);
        return new ResponseEntity<PostResponse>(posts,HttpStatus.OK);
    }

    //get post by id
    @GetMapping("/post/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
        PostDto post = this.postService.getPostById(postId);
        return new ResponseEntity<PostDto>(post,HttpStatus.OK);
    }

    //Delete post by id
    @DeleteMapping("post/{postId}")
    public ResponseEntity<ApiResponse> deletePostById(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("post deleted sucessfully",true),HttpStatus.OK);
    }

    //Search
    @GetMapping("/posts/search/{keywords}")
    public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable("keywords") String keywords){
        List<PostDto> result = this.postService.searchPost(keywords);
        return new ResponseEntity<List<PostDto>>(result,HttpStatus.OK);
    }
}