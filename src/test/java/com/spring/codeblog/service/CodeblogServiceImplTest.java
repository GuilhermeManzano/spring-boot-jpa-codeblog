package com.spring.codeblog.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodedBlogRepository;
import com.spring.codeblog.serviceimpl.CodeblogServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CodeblogServiceImplTest {
	
	@InjectMocks
	private CodeblogServiceImpl codingBlogService;
	
	@Mock
	private CodedBlogRepository codeBlogRepository;

	@Test
	public void findAllTest() {
		List<Post> list = codingBlogService.findAll();
		
		assertThat(list).isNotNull();
	}
	
	@Test
	public void findByIdTestWithNoReturn() {
		Post post = codingBlogService.findById(1);
		
		assertThat(post).isNotNull();
	}
	
	@Test
	public void findByIdTestWithReturn() {
		Post retorno = new Post();
		retorno.setAutor("GUi");
	    Optional<Post> opt = Optional.of(retorno);

	    when(codeBlogRepository.findById(anyLong())).thenReturn(opt);

		Post post = codingBlogService.findById(1);
		assertThat(post).isNotNull();
	}
	
	@Test
	public void saveTest() {
		Post retorno = new Post();
		retorno.setAutor("GUi");
		
		codingBlogService.save(retorno);
		
		assertThat(retorno).isNotNull();
	}
}
