package com.blog.codeblog.service;

import java.util.List;
import java.util.Optional;

import com.blog.codeblog.entity.Post;

public interface CodeblogService {

	List<Post> findAll();
	Post findById(long id);
	Post save(Post post);
	void delete(Post post);
	
}
