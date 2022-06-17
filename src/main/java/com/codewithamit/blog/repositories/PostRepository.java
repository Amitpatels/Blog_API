package com.codewithamit.blog.repositories;

import com.codewithamit.blog.entities.Category;
import com.codewithamit.blog.entities.Post;
import com.codewithamit.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

    //some issue with hibernate 5.1. issue
    //List<Post> findByTitleContaining(String title);

    @Query("select p from Post p where p.title like :key")
    List<Post> searchbyTitle(@Param("key") String title);
}
