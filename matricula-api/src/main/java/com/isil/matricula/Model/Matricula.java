package com.isil.matricula.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "Matricula")
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int matricula_id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "alumno_id")
	private Alumno alumno;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "curso_id")
	private Curso curso;
	private LocalDate fecha_inscripcion;
}
