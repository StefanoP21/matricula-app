package com.isil.matricula.Controller;

import com.isil.matricula.Model.Matricula;
import com.isil.matricula.Service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {
	@Autowired
	private IMatriculaService service;

	@PostMapping
	public ResponseEntity<Matricula> save(@RequestBody Matricula matricula) {
		return ResponseEntity.ok(service.save(matricula));
	}

	@GetMapping
	public ResponseEntity<List<Matricula>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Matricula> findById(@PathVariable("id") int id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@GetMapping(params = "dni")
	public ResponseEntity<List<Matricula>> findByDni(@RequestParam("dni") String dni) {
		return ResponseEntity.ok(service.findByDni(dni));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Matricula> updateById(@RequestBody Matricula matricula, @PathVariable int id) {
		return ResponseEntity.ok(service.updateById(matricula, id));
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteAll() {
		service.deleteAll();
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
