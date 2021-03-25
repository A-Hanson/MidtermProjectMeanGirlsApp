package com.skilldistillery.jpameangirls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MeanGirlsAppApplication extends SpringBootServletInitializer {
	  @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(MeanGirlsAppApplication.class);
	  }
	public static void main(String[] args) {
		SpringApplication.run(MeanGirlsAppApplication.class, args);
	}

}
