package com.desafio.pontosgps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.pontosgps.entities.Point;

public interface PointRepository extends JpaRepository<Point, Integer> {

}
