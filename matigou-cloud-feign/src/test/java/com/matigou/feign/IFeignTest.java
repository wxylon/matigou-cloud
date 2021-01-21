package com.matigou.feign;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = FeignService.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IFeignTest {

	@Autowired
	IFeign iFeign;

	@Test
	public void testFeignAPIhello() {
		assertThat(iFeign.hello()).isEqualTo("success");
	}

	@Test
	public void testFeignAPIgoodbye() {
		assertThat(iFeign.goodbye()).isEqualTo("goodbye");
	}
}