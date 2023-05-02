package com.lucas.api.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.lucas.api.IfoodApiApplication;
import com.lucas.api.domain.modelo.Restaurante;
import com.lucas.domain.repository.RestauranteRepository;

public class ConsultaRestauranteMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(IfoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

		List<Restaurante> todosRestaurantes = restauranteRepository.listar();

		for (Restaurante restaurante : todosRestaurantes) {
			System.out.printf("%s - %f - %s\n", restaurante.getNome(), restaurante.getTaxaFrete(),
					restaurante.getCozinha().getNome());
		}
	}

}
