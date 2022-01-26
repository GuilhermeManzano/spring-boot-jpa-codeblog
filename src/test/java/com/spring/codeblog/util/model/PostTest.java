package com.spring.codeblog.util.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.spring.codeblog.model.Post;

public class PostTest {
	private Post post;
	
	@Test
	public void getterSetterTest() {
		post = new Post();
		
		post.setAutor("Guilherme");
		post.setData(LocalDate.now());
		post.setId((long) 1);
		post.setTexto("Este é um artigo de memorias");
		post.setTitulo("Memorias");
		
		assertThat(post.getAutor()).isEqualTo("Guilherme");
		assertThat(post.getData()).isEqualTo(LocalDate.now());
		assertThat(post.getId()).isEqualTo((long) 1);
		assertThat(post.getTexto()).isEqualTo("Este é um artigo de memorias");
		assertThat(post.getTitulo()).isEqualTo("Memorias");
		
		post.toString();
	}
}
