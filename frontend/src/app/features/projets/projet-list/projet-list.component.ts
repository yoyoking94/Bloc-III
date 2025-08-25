import { Component, OnInit } from '@angular/core';
import { ProjetService } from '../../../core/services/projet.service';
import { Projet } from '../../../core/models/projet.model';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-projet-list',
  imports: [CommonModule, RouterLink],
  templateUrl: './projet-list.component.html',
})
export class ProjetListComponent implements OnInit {
  projets: Projet[] = [];

  constructor(private projetService: ProjetService) {}

  ngOnInit() {
    this.projetService.getProjets().subscribe({
      next: (data) => (this.projets = data),
    });
  }
}
