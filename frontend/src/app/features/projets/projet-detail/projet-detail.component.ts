import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProjetService } from '../../../core/services/projet.service';
import { Projet } from '../../../core/models/projet.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-projet-detail',
  imports: [CommonModule],
  templateUrl: './projet-detail.component.html'
})
export class ProjetDetailComponent implements OnInit {
  projet?: Projet;

  constructor(private route: ActivatedRoute, private projetService: ProjetService) {}

  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.projetService.getProjetById(id).subscribe({
      next: data => this.projet = data
    });
  }
}
