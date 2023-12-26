package com.isil.matricula.Controller;

import com.isil.matricula.Model.Curso;
import com.isil.matricula.Service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/cursos")
public class CursoController {
	@Autowired
	private ICursoService service;

	@GetMapping
	public ResponseEntity<List<Curso>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
}
