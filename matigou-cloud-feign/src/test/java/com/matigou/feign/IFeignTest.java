package com.matigou.feign;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = FeignService.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IFeignTest {

	@Qualifier("feignService")
	@Autowired
	IFeign iFeign;

	@Test
	public void testFeignAPIhello() {
		String str = iFeign.hello();
		assertThat(str.equals("success"));
	}

	@Test
	public void testFeignAPIgoodbye() {
		assertThat(iFeign.goodbye()).isEqualTo("goodbye1");
	}
}