package com.tagify;

import com.tagify.config.EnvLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TagifyApplication {

	public static void main(String[] args) {
        EnvLoader.load();
        SpringApplication.run(TagifyApplication.class, args);
	}

}
