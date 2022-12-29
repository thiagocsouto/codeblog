package com.blog.codeblog;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.blog.codeblog.entity.Post;
import com.blog.codeblog.repository.CodeblogRepository;


@DataJpaTest
public class codeblogServiceTests {
	
	@Autowired
	private CodeblogRepository codeblogRepository;
	
	
	@BeforeEach
	void initService() {
	}
 
	@Test
	void salvarPost() {
	    
		Post post = new Post();
		post.setId(1l); 
		post.setAutor("Teste");
		post.setData(LocalDate.now());  
		post.setTitulo("Teste");
		post.setTexto("Apenas um teste.");
		
		codeblogRepository.save(post);
		
		assertThat(post.getId()).isGreaterThan(0);
		
	}
	
	@Test
	void ListarTodosPost() {
		
		List<Post> posts = codeblogRepository.findAll();
		
		assertThat(posts.size()).isGreaterThan(0);
		
	}

}
