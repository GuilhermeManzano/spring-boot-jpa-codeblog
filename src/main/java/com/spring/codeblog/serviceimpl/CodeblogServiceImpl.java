package com.spring.codeblog.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodedBlogRepository;
import com.spring.codeblog.service.CodeBlogService;

@Service
public class CodeblogServiceImpl implements CodeBlogService {
	
	@Autowired
	CodedBlogRepository codeBlogRepository;

	@Override
	public List<Post> findAll() {
		return codeBlogRepository.findAll();
	}

	@Override
	public Post findById(long id) {
		Optional<Post> retorno = codeBlogRepository.findById(id);

		if (retorno.isPresent()) {
			return retorno.get();
		}
		
		return new Post();
	}

	@Override
	public Post save(Post post) {
		return codeBlogRepository.save(post);
	}
}
