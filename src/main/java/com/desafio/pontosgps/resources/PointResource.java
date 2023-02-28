package com.desafio.pontosgps.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafio.pontosgps.dto.PointDTO;
import com.desafio.pontosgps.entities.Point;
import com.desafio.pontosgps.services.PointService;

@RestController
@RequestMapping("/points")
public class PointResource {
	@Autowired
	private PointService service;
	
	
	@GetMapping
	public ResponseEntity<List<PointDTO>> findAll() {
		List<PointDTO> resp = listToDTO(service.findAll());
		
		return ResponseEntity.ok().body(resp);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody PointDTO dto) {
		Point obj = service.fromDTO(dto);
		obj = service.save(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value="/near")
	public ResponseEntity<List<PointDTO>> pointsNear(@RequestParam(value="x") int x,
			@RequestParam(value="y") int y, @RequestParam(value="dmax") int dmax) {

		List<PointDTO> resp = listToDTO(service.pointsNear(x, y, dmax));
		
		return ResponseEntity.ok().body(resp);
	}
	
	private List<PointDTO> listToDTO(List<Point> list) {
		return list.stream().map(p -> new PointDTO(p)).collect(Collectors.toList());
	}
}
