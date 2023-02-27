package com.desafio.pontosgps.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.pontosgps.dto.PointDTO;
import com.desafio.pontosgps.entities.Point;
import com.desafio.pontosgps.repositories.PointRepository;

@Service
public class PointService {
	
	@Autowired
	private PointRepository repository;
	
	
	public Point save(Point obj) {
		return repository.save(obj);
	}
	
	public Point fromDTO(PointDTO dto) {
		return new Point(null, dto.getName(), dto.getX(), dto.getY());
	}
	
	public List<Point> findAll() {
		return repository.findAll();
	}
}
