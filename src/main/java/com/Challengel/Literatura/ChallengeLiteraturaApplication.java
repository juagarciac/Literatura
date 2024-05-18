package com.Challengel.Literatura;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


public class ChallengeLiteraturaApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(ChallengeLiteraturaApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Principal.menu();
	}
}
