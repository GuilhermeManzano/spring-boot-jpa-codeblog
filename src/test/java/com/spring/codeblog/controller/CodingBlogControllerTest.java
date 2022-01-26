package com.spring.codeblog.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.serviceimpl.CodeblogServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CodingBlogControllerTest {
	
	@InjectMocks
	private CodingBlogController codingBlogController;
	
	@Mock
	private CodeblogServiceImpl codeblogService;
	
	@Test
	public void getPostsTest() {
		ModelAndView mv = codingBlogController.getPosts();
		
		assertThat(mv).isNotNull();
	}
	
	@Test
	public void getPostsDetailsTest() {
		ModelAndView mv = codingBlogController.getPostsDetails(1);
		
		assertThat(mv).isNotNull();
	}
	
	@Test
	public void getPostFormTest() {
		String text = codingBlogController.getPostForm();
		
		assertThat(text).isNotNull();
	}
	
	@Test
	public void savePostTest() {
		Post post = new Post();
		post.setAutor("Guilherme");
		post.setData(LocalDate.now());
		
	    BindingResult result = mock(BindingResult.class);
	    when(result.hasErrors()).thenReturn(false);
		
		String text = codingBlogController.savePost(post, result, null);
		
		assertThat(text).isNotNull();
	}
	
	@Test
	public void savePostTestFalse() {
		Post post = new Post();
		post.setAutor("Guilherme");
		post.setData(LocalDate.now());
		
	    BindingResult result = mock(BindingResult.class);
	    when(result.hasErrors()).thenReturn(true);
	
	    RedirectAttributes flashAttributes = mock(RedirectAttributes.class);
	    
		codingBlogController.savePost(post, result, flashAttributes);
	}
}
