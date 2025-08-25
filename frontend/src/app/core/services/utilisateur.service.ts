// src/app/core/services/utilisateur.service.ts
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Utilisateur } from '../models/utilisateur.model';

@Injectable({
  providedIn: 'root',
})
export class UtilisateurService {
  private apiUrl = 'http://localhost:8080/api/utilisateurs';

  constructor(private http: HttpClient) {}

  inscrire(utilisateur: Utilisateur): Observable<Utilisateur> {
    return this.http
      .post<Utilisateur>(`${this.apiUrl}/register`, utilisateur)
      .pipe(catchError(this.handleError));
  }

  login(credentials: {
    email: string;
    motDePasse: string;
  }): Observable<Utilisateur> {
    return this.http
      .post<Utilisateur>(`${this.apiUrl}/login`, credentials)
      .pipe(catchError(this.handleError));
  }

  getUtilisateurs(): Observable<Utilisateur[]> {
    return this.http
      .get<Utilisateur[]>(this.apiUrl)
      .pipe(catchError(this.handleError));
  }

  getUtilisateurById(id: number): Observable<Utilisateur> {
    return this.http
      .get<Utilisateur>(`${this.apiUrl}/${id}`)
      .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    // Personnalise l'affichage ou le logging de l’erreur ici
    return throwError(() => error);
  }
}
