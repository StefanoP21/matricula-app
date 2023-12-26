import { Component, OnInit } from '@angular/core';
import { Matricula } from 'src/app/model/matricula';
import { MatriculaService } from 'src/app/services/matricula.service';

@Component({
  selector: 'app-matricula-list',
  templateUrl: './matricula-list.component.html',
  styleUrls: ['./matricula-list.component.scss'],
})
export class MatriculaListComponent implements OnInit {
  matriculas: Matricula[] = [];
  dni = '';

  constructor(private matriculaService: MatriculaService) {}

  ngOnInit(): void {
    this.readMatriculas();
  }

  readMatriculas(): void {
    this.matriculaService.readAll().subscribe({
      next: (matriculas) => {
        this.matriculas = matriculas;
      },
      error: (error) => {
        console.log(error);
      },
    });
  }

  deleteAllMatriculas(): void {
    this.matriculaService.deleteAll().subscribe({
      next: (response) => {
        console.log(response);
        this.readMatriculas();
      },
      error: (error) => {
        console.log(error);
      },
    });
  }

  deleteMatricula(id: any): void {
    this.matriculaService.delete(id).subscribe({
      next: (response) => {
        console.log(response);
        this.readMatriculas();
      },
      error: (error) => {
        console.log(error);
      },
    });
  }

  searchByDni(): void {
    this.matriculaService.searchByDni(this.dni).subscribe({
      next: (matriculas) => {
        this.matriculas = matriculas;
        console.log(matriculas);
      },
      error: (error) => {
        console.log(error);
      },
    });
  }
}
