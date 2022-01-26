package com.spring.codeblog.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodedBlogRepository;

@Component
public class DummyData {
	private static final Logger LOGGER = LoggerFactory.getLogger(DummyData.class);
	
	private static final String TEXTO = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has "
			+ "been the industry's standard dummy text ever since the 1500s, when an unknown printer took a"
			+ " galley of type and scrambled it to make a type specimen book. It has survived not only five "
			+ "centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It "
			+ "was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, "
			+ "and more recently with desktop publishing software like Aldus PageMaker including versions of "
			+ "Lorem Ipsum.";

	@Autowired
	private CodedBlogRepository codedBlogRepository;

	public void savePosts() {
		String nomeAutor = "Denis Machado";
		String titulo = "API REST";
		Post post1 = persisteDadosPost(nomeAutor, titulo);

		nomeAutor = "Michelli Brito";
		titulo = "API REST";
		Post post2 = persisteDadosPost(nomeAutor, titulo);

		List<Post> postList = new ArrayList<>();
		postList.add(post1);
		postList.add(post2);

		postList.forEach(post -> {
			Post postSaved = codedBlogRepository.save(post);
			LOGGER.info("Post salvo: {}", postSaved.getId());
		});
	}

	private Post persisteDadosPost(String nomeAutor, String titulo) {
		Post post = new Post();
		post.setAutor(nomeAutor);
		post.setData(LocalDate.now());
		post.setTitulo(titulo);
		post.setTexto(TEXTO);

		return post;
	}
}