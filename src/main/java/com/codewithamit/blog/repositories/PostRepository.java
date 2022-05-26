package com.codewithamit.blog.repositories;

import com.codewithamit.blog.entities.Category;
import com.codewithamit.blog.entities.Post;
import com.codewithamit.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
