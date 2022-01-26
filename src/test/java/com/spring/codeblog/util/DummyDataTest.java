package com.spring.codeblog.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodedBlogRepository;

@ExtendWith(MockitoExtension.class)
public class DummyDataTest {

	@InjectMocks
	private DummyData dummyData;

	@Mock
	private CodedBlogRepository codedBlogRepository;

	@Test
	public void savePostsTest() {
		Post post = new Post();
		post.setAutor("Denis Machado");
		post.setData(LocalDate.now());
		post.setTitulo("API REST");
		when(codedBlogRepository.save(any())).thenReturn(post);

		dummyData.savePosts();
		assertThat(post).isNotNull();
	}
}
