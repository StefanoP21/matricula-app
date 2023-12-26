import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Matricula } from '../model/matricula';

const baseURL = 'http://localhost:8080/api/matriculas';

@Injectable({
  providedIn: 'root',
})
export class MatriculaService {
  constructor(private httpClient: HttpClient) {}

  readAll(): Observable<any> {
    return this.httpClient.get(baseURL);
  }

  read(id: number): Observable<any> {
    return this.httpClient.get(`${baseURL}/${id}`);
  }

  create(data: Matricula): Observable<any> {
    return this.httpClient.post(baseURL, data);
  }

  update(id: number, data: Matricula): Observable<any> {
    return this.httpClient.put(`${baseURL}/${id}`, data);
  }

  delete(id: number): Observable<any> {
    return this.httpClient.delete(`${baseURL}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.httpClient.delete(baseURL);
  }

  searchByDni(dni: string): Observable<any> {
    return this.httpClient.get(`${baseURL}?dni=${dni}`);
  }
}
