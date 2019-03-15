package com.galvanize.gmdbmonolith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GmdbMonolithApplication extends SpringBootServletInitializer {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder appBuilder)
	{
		return appBuilder.sources(GmdbMonolithApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(GmdbMonolithApplication.class, args);
	}

}
