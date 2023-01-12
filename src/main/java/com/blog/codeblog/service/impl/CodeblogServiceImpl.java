package com.blog.codeblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.codeblog.entity.Post;
import com.blog.codeblog.repository.CodeblogRepository;
import com.blog.codeblog.service.CodeblogService;

@Service
public class CodeblogServiceImpl implements CodeblogService{

	@Autowired
	private CodeblogRepository codeblogRepository;
	
	
	public List<Post> findAll() {
		return codeblogRepository.findAll();
	}

	public Post findById(long id) {
		return codeblogRepository.findById(id).get();
	}

	public Post save(Post post) {
		
		if (post.getTexto() == null) {
			throw new NullPointerException("Texto não pode ter valor nulo");
		}
		
		return codeblogRepository.save(post);
	}

	public void delete(Post post) {
		codeblogRepository.delete(post);
	}

}
