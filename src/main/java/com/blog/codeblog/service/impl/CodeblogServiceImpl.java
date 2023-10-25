package com.blog.codeblog.service.impl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.codeblog.dto.PostDto;
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
	    return codeblogRepository.findById(id)
	            .orElseThrow(() -> new EntityNotFoundException("Post não encontrado com ID: " + id));
	}


	public Post save(PostDto postDto) {
		
		if (postDto.texto() == null) {
			throw new NullPointerException("Texto não pode ter valor nulo");
		}
		
		Post post = new Post();
		post.setId(postDto.id());
		post.setTitulo(postDto.titulo());
		post.setAutor(postDto.autor());
		post.setData(LocalDate.now()); 
		post.setTexto(postDto.texto());
		
		return codeblogRepository.save(post);
	}

	public void delete(Post post) {
		codeblogRepository.delete(post);
	}

}
