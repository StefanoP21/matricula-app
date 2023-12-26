package com.isil.matricula.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Profesor")
public class Profesor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int profesor_id;
	private String nombres;
	private String apellidos;
	private String dni;
	private String carrera;
}
