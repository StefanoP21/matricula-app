package com.isil.matricula.Service;

import com.isil.matricula.Model.Matricula;
import com.isil.matricula.Repository.IMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements IMatriculaService {
	@Autowired
	private IMatriculaRepository repo;

	@Override
	public Matricula save(Matricula matricula) {
		// TODO: validar que el alumno no se haya matriculado en el curso antes
		if (repo.findByAlumnoAndCurso(matricula.getAlumno().getAlumno_id(), matricula.getCurso().getCurso_id()).isEmpty()) {
			return repo.save(matricula);
		} else {
			throw new RuntimeException("El alumno ya se encuentra matriculado en el curso seleccionado");
		}
	}

	@Override
	public List<Matricula> findAll() {
		return repo.findAll();
	}

	@Override
	public Matricula findById(int id) {
		return repo.findById(id).orElseThrow();
	}

	@Override
	public List<Matricula> findByDni(String dni) {
		return repo.findByDni(dni);
	}

	@Override
	public List<Matricula> findByAlumnoAndCurso(int alumno_id, int curso_id) {
		return repo.findByAlumnoAndCurso(alumno_id, curso_id);
	}

	@Override
	public Matricula updateById(Matricula matricula, int id) {
		Matricula existingMatricula = repo.findById(id).orElseThrow();
		existingMatricula.setAlumno(matricula.getAlumno());
		existingMatricula.setCurso(matricula.getCurso());
		existingMatricula.setFecha_inscripcion(matricula.getFecha_inscripcion());

		return repo.save(existingMatricula);
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
	}

	@Override
	public void deleteById(int id) {
		repo.deleteById(id);
	}
}
