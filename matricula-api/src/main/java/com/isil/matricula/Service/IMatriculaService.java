package com.isil.matricula.Service;

import com.isil.matricula.Model.Matricula;

import java.util.List;

public interface IMatriculaService {
	Matricula save(Matricula matricula);
	List<Matricula> findAll();
	Matricula findById(int id);
	List<Matricula> findByDni(String dni);
	List<Matricula> findByAlumnoAndCurso(int alumno_id, int curso_id);
	Matricula updateById(Matricula matricula, int id);
	void deleteAll();
	void deleteById(int id);
}
