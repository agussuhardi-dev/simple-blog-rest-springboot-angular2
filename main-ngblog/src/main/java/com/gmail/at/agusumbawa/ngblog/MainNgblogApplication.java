package com.gmail.at.agusumbawa.ngblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class MainNgblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainNgblogApplication.class, args);
	}
}
