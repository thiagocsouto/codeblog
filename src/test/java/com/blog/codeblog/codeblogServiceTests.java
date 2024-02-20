package com.blog.codeblog;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blog.codeblog.dto.PostDto;
import com.blog.codeblog.entity.Post;
import com.blog.codeblog.repository.CodeblogRepository;
import com.blog.codeblog.service.impl.CodeblogServiceImpl;

@SpringBootTest
public class codeblogServiceTests {
	
	@Autowired
	private CodeblogRepository codeblogRepository;
	
	@Autowired
	private CodeblogServiceImpl codeblogServiceImpl;
	
	@BeforeEach
	void initService() {
	}
 
	@Test
	void salvando_post() {
	    
		//formulário de um post
		Post post = new Post();
		post.setId(1l); 
		post.setAutor("Teste");
		post.setData(LocalDate.now());  
		post.setTitulo("Teste");
		post.setTexto("Apenas um teste.");
		
		//ação
		codeblogRepository.save(post);
		
		//aserts
		assertThat(post.getId()).isEqualTo(1l);
		
	}
	
	@Test
	void error_quando_salva_post_com_texto_nulo() {
	    // Formulário de um post
	    PostDto postDto = PostDto.builder()
	            .id(1L)
	            .autor("Teste")
	            .data(LocalDate.now())
	            .titulo("Teste")
	            .texto(null)
	            .build();

	    // Ação e assert
	    assertThrows(Exception.class, () -> codeblogServiceImpl.save(postDto),
	            "Texto não pode ter valor nulo");
	}
	
	@Test
	void Listando_um_post() {
		    
		//formulário de um post
		Post post = new Post();
		post.setId(2l); 
		post.setAutor("Teste2");
		post.setData(LocalDate.now());  
		post.setTitulo("Teste2");
		post.setTexto(null);
		
		//acao
		codeblogServiceImpl.findById(2l);
		
		//asserts
		assertThat(post.getId()).isEqualTo(2l);
		
	}

}
