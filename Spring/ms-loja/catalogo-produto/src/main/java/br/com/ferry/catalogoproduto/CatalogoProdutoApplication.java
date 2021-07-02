package br.com.ferry.catalogoproduto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CatalogoProdutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogoProdutoApplication.class, args);
	}

}
