package com.blog.codeblog.service;

import java.util.List;

import com.blog.codeblog.dto.PostDto;
import com.blog.codeblog.entity.Post;

public interface CodeblogService {

	List<Post> findAll();
	Post findById(long id);
	Post save(PostDto postDto); 
	void delete(Post post);
	
}
