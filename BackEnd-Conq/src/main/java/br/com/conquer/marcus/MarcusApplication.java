package br.com.conquer.marcus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*

@Bean: Basicamente quando você coloca a anotação @Bean, você está dizendo pro Spring que quer criar esse 
objeto e deixar ele disponível para outras classes utilizarem ele como dependência, @componente sem a anotação
o metado não é chamado.

@SpringBootApplication: é usada para marcar uma classe de configuração que declara um ou mais 
métodos @Bean e também dispara a configuração automática e a varredura de componentes. 
*/
/*Hibernate: Um framework objeto relacional que simplificava a interação entre a aplicação e o banco de dados,implementa as especificações */
/*
 JPA: conjunto de especificações para definir um comportamento de persistência de dados, quem implmenta as especificações o hibernate e etc..*/

@SpringBootApplication // metadado
public class MarcusApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarcusApplication.class, args);
	}

}
