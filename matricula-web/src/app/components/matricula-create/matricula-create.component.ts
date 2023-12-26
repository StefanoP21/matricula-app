import { Component, OnInit } from '@angular/core';
import { Alumno } from 'src/app/model/alumno';
import { Curso } from 'src/app/model/curso';
import { AlumnoService } from 'src/app/services/alumno.service';
import { CursoService } from 'src/app/services/curso.service';
import { MatriculaService } from 'src/app/services/matricula.service';
import * as bootstrap from 'bootstrap';

@Component({
  selector: 'app-matricula-create',
  templateUrl: './matricula-create.component.html',
  styleUrls: ['./matricula-create.component.scss'],
})
export class MatriculaCreateComponent implements OnInit {
  matricula = {
    alumno: 0,
    curso: 0,
    fecha_inscripcion: '',
  };

  submitted = false;

  alumnos: Alumno[] = [];
  cursos: Curso[] = [];

  errorMessage = '';

  constructor(
    private matriculaService: MatriculaService,
    private alumnoService: AlumnoService,
    private cursoService: CursoService
  ) {}

  ngOnInit(): void {
    this.getAlumnos();
    this.getCursos();
    this.matricula.fecha_inscripcion = this.getTodayDate();
  }

  getAlumnos(): void {
    this.alumnoService.readAll().subscribe({
      next: (res) => {
        this.alumnos = res;
      },
      error: (e) => console.error(e),
    });
  }

  getCursos(): void {
    this.cursoService.readAll().subscribe({
      next: (res) => {
        this.cursos = res;
      },
      error: (e) => console.error(e),
    });
  }

  getTodayDate(): string {
    const date = new Date();
    const year = date.getFullYear();
    const month = ('0' + (date.getMonth() + 1)).slice(-2);
    const day = ('0' + date.getDate()).slice(-2);
    return `${year}-${month}-${day}`;
  }

  createMatricula(): void {
    if (this.matricula.alumno === 0 || this.matricula.curso === 0) {
      alert('Por favor, selecciona un alumno y un curso.');
      return;
    }

    const data = {
      alumno: {
        alumno_id: this.matricula.alumno,
      },
      curso: {
        curso_id: this.matricula.curso,
      },
      fecha_inscripcion: this.matricula.fecha_inscripcion,
    };

    this.matriculaService.create(data).subscribe({
      next: (res) => {
        console.log(res);
        this.submitted = true;
      },
      error: (e) => {
        if (e.status === 500) {
          this.errorMessage = e.error.message;
          const errorModalElement = document.getElementById('errorModal');
          if (errorModalElement) {
            const errorModal = new bootstrap.Modal(errorModalElement, {});
            errorModal.show();
          } else {
            console.error('No se encontró el elemento #errorModal');
          }
        } else {
          console.error(e);
        }
      },
    });
  }

  newMatricula(): void {
    this.submitted = false;
    this.matricula = {
      alumno: 0,
      curso: 0,
      fecha_inscripcion: this.getTodayDate(),
    };
  }
}
