package com.Challengel.Literatura;


import com.Challengel.Literatura.objetos.Libro;
import com.Challengel.Literatura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/*@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})*/
@SpringBootApplication(exclude = {ServletWebServerFactoryAutoConfiguration.class})
public class ChallengeLiteraturaApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository repository ;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeLiteraturaApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.menu();

	}
}
