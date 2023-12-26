package com.isil.matricula.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Alumno")
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int alumno_id;
	private String nombres;
	private String apellidos;
	private String dni;
	private String telefono;
}
