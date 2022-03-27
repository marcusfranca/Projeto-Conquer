package br.com.conquer.marcus;

import br.com.conquer.marcus.model.User;
import br.com.conquer.marcus.repository.IUserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication // metadado
public class MarcusApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarcusApplication.class, args);
	}

}
