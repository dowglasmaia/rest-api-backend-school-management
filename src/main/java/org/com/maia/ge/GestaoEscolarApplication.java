package org.com.maia.ge;

import java.util.TimeZone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestaoEscolarApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GestaoEscolarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Definindo o Time-Zone Local - Resolvendo problema com horas no banco de Dados
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	}

}
