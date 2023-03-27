package com.leandro.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.leandro.bookstore.service.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService bdservice;

	@Bean
	public void instanciaBasedeDados() {
		this.bdservice.instanciaBasedeDados();

	}
}
