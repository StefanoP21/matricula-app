package com.isil.matricula.Service;

import com.isil.matricula.Model.Alumno;
import com.isil.matricula.Repository.IAlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements IAlumnoService {
	@Autowired
	private IAlumnoRepository repo;

	@Override
	public List<Alumno> findAll() {
		return repo.findAll();
	}
}
