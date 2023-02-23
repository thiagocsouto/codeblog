package com.blog.codeblog;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
	    
		//formulário de um post
		Post post = new Post();
		post.setId(1l); 
		post.setAutor("Teste");
		post.setData(LocalDate.now());  
		post.setTitulo("Teste");
		post.setTexto(null);
		
		 //acao
        Exception exception = assertThrows(Exception.class, () -> codeblogServiceImpl.save(post));
    
        //asserts
        assertEquals("Texto não pode ter valor nulo", exception.getMessage());

	}
	
	@Test
	void Listando_um_post() {
		    
		//formulário de um post
		Post post2 = new Post();
		post2.setId(2l); 
		post2.setAutor("Teste2");
		post2.setData(LocalDate.now());  
		post2.setTitulo("Teste2");
		post2.setTexto(null);
		
		//acao
		codeblogServiceImpl.findById(2l);
		
		//asserts
		assertThat(post2.getId()).isEqualTo(2l);
		
	}

}
