package com.docencia.hexagonal_auth_tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicacion Hexagonal Auth Tasks.
 * Inicia la aplicacion Spring Boot con la arquitectura hexagonal.
 */
@SpringBootApplication
public class HexagonalAuthTasksApplication {

	/**
	 * Metodo principal que inicia la aplicacion Spring Boot.
	 *
	 * @param args argumentos de linea de comandos
	 */
	public static void main(String[] args) {
		SpringApplication.run(HexagonalAuthTasksApplication.class, args);
	}

}
