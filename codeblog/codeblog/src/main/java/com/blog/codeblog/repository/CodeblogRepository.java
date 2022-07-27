package com.blog.codeblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.codeblog.entity.Post;

public interface CodeblogRepository extends JpaRepository<Post, Long> {

}
