package com.raj.shashi.spring.vertx;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.vertx.core.Vertx;

/**
 * @author rajs
 *
 */
@SpringBootApplication
public class MainApplication {

	@Autowired
	private SimpleVertx simpleVertx;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@PostConstruct
	public void deployVerticle() {
		Vertx.vertx().deployVerticle(simpleVertx);
	}

}
