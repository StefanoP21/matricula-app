import { Alumno } from './alumno';
import { Curso } from './curso';

export class Matricula {
  matricula_id?: number;
  alumno?: Alumno;
  curso?: Curso;
  fecha_inscripcion?: string;

  constructor() {}
}
