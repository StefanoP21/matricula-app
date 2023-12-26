package com.isil.matricula.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Curso")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int curso_id;
	private String nombre;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "profesor_id")
	private Profesor profesor;
}
