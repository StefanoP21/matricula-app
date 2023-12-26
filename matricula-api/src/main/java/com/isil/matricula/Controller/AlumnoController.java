package com.isil.matricula.Controller;

import com.isil.matricula.Model.Alumno;
import com.isil.matricula.Service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
	@Autowired
	private IAlumnoService service;

	@GetMapping
	public ResponseEntity<List<Alumno>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

}
