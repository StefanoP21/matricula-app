package com.isil.matricula.Service;

import com.isil.matricula.Model.Curso;
import com.isil.matricula.Repository.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements ICursoService {
	@Autowired
	private ICursoRepository repo;

	@Override
	public List<Curso> findAll() {
		return repo.findAll();
	}
}
