package com.testeNexti.testeNextiBack;

import com.testeNexti.testeNextiBack.models.Client;
import com.testeNexti.testeNextiBack.models.Product;
import com.testeNexti.testeNextiBack.repository.ClientRepository;
import com.testeNexti.testeNextiBack.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.LongStream;

@SpringBootApplication
public class TesteNextiBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteNextiBackApplication.class, args);
	}


}
