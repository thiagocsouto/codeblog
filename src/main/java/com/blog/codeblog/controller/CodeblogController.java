package com.blog.codeblog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.blog.codeblog.dto.PostDto;
import com.blog.codeblog.entity.Post;
import com.blog.codeblog.service.CodeblogService;


@Controller
public class CodeblogController {
	
	@Autowired
	private CodeblogService codeblogService;
	
	@GetMapping(value="/posts")
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("post/posts");
		List<Post> posts = codeblogService.findAll();
		mv.addObject("posts", posts);
		return mv;
	}
	
	@GetMapping(value="/posts/{id}")
	public ModelAndView getPostsDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("post/postsDetails");
		Post post = codeblogService.findById(id);
		mv.addObject("post", post);
		return mv;
	}
	
	@GetMapping(value="/new-post")
	public ModelAndView getPostForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName( "post/postForm");
		mv.addObject("postDto", new PostDto(null, null, null, null, null));
		return mv;		
	}
	
	@PostMapping(value="/new-post")
	public ModelAndView savePost(@Valid PostDto postDto, BindingResult result) {
		ModelAndView mv = new ModelAndView(); 
		if(result.hasErrors()) {
			mv.setViewName("/post/postForm");
			mv.addObject(postDto);
		    return mv;
		}
		codeblogService.save(postDto);
		mv.setViewName("redirect:/posts");
		return mv;
	}

}
