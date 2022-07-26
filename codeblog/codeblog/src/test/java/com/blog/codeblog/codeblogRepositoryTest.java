package com.blog.codeblog;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.blog.codeblog.entity.Post;
import com.blog.codeblog.repository.CodeblogRepository;
import com.blog.codeblog.service.CodeblogService;


@ExtendWith(MockitoExtension.class)
public class codeblogRepositoryTest {
	
	@Mock
	private CodeblogRepository codeblogRepository;
	
	@InjectMocks
	private CodeblogService codeblogService;
	
//	@BeforeEach
//	void initService() {
//		CodeblogService codeblogService = new CodeblogService(codeblogRepository);
//	}
 
//	@Test
//	void salvarPost() {
//	    
//		Post post = new Post(5l , "teste", null, LocalDate.parse("2022-04-26"), "teste");
//		doReturn(post).when(codeblogRepository).save(any());
//		
//		Post salvarPost = codeblogRepository.save(post);
//		
//		assertNotNull(salvarPost);
//		
//	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	@Test
//	public void salvarPost() {	    
//		Post post = new Post(5l , "teste", null, LocalDate.parse("2022-04-26"), "teste");
//		when(codeblogRepository.save(any(Post.class))).thenReturn(post);
//		
//		Post salvarPost = codeblogService.save(post); 
//		
//		assertNotNull(salvarPost);
//		
//	}
	
//	@Test
//	void salvarPost2() {
//	    
//		Post post = new Post(6l , "teste", "teste", LocalDate.parse("2022-04-26"), "teste");
//		doReturn(post).when(codeblogRepository).save(any());
//		
//        Optional<Post> salvarPost = codeblogRepository.findById(5l);
//		
//		Assertions.assertTrue(salvarPost.isPresent());
//		
//	}
}
