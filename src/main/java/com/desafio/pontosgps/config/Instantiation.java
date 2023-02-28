package com.desafio.pontosgps.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.desafio.pontosgps.entities.Point;
import com.desafio.pontosgps.repositories.PointRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private PointRepository pointRepository;
	

	@Override
	public void run(String... args) throws Exception {
		pointRepository.deleteAll();
		
		pointRepository.save(new Point(null, "Lanchonete", 27, 12));
		pointRepository.save(new Point(null, "Posto", 31, 18));
		pointRepository.save(new Point(null, "Joalheria", 15, 12));
		pointRepository.save(new Point(null, "Floricultura", 19, 21));
		pointRepository.save(new Point(null, "Pub", 12, 8));
		pointRepository.save(new Point(null, "Supermercado", 23, 6));
		pointRepository.save(new Point(null, "Churrascaria", 28, 2));
	}

}
