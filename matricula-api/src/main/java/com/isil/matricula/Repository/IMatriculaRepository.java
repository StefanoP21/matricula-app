package com.isil.matricula.Repository;

import com.isil.matricula.Model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMatriculaRepository extends JpaRepository<Matricula, Integer> {
	@Query("SELECT m FROM Matricula m WHERE m.alumno.dni  LIKE %?1%")
	List<Matricula> findByDni(String dni);

	@Query("SELECT m FROM Matricula m WHERE m.alumno.alumno_id = ?1 AND m.curso.curso_id = ?2")
	List<Matricula> findByAlumnoAndCurso(int alumno_id, int curso_id);
}
