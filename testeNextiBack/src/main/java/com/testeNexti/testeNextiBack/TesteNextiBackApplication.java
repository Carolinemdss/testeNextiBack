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

	@Bean
	CommandLineRunner init(ProductRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11)
					.mapToObj(i -> {
						Product p = new Product();
						p.setSKU(123456);
						p.setName("Name" + i );
						p.setDescription("Description" + i);
						p.setPrice(299.90);
						p.setQuantity(10);

						return p;
					})
					.map(v -> repository.save(v))
					.forEach(System.out::println);
		};
	}

}
