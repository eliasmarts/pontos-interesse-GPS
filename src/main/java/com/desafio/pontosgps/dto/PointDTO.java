package com.desafio.pontosgps.dto;

import java.io.Serializable;

import com.desafio.pontosgps.entities.Point;

public class PointDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Integer x;
	private Integer y;
	
	public PointDTO() {
	}

	public PointDTO(Point obj) {
		this.name = obj.getName();
		this.x = obj.getX();
		this.y = obj.getY();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}
}
