package com.matigou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MatigouCloudFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatigouCloudFeignApplication.class, args);
	}

}
