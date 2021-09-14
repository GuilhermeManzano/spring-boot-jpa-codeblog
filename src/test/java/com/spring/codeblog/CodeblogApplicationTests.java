package com.spring.codeblog;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CodeblogApplicationTests {

	@Test
	void contextLoads() {
		CodeblogApplication cd = new CodeblogApplication();
		
		assertThat(cd).isNotNull();
	}

}
