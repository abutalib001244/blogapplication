package com.blogapplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapplication.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
