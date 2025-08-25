import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { TacheService } from '../../../core/services/tache.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-tache-form',
  imports:[CommonModule, ReactiveFormsModule],
  templateUrl: './tache-form.component.html',
})
export class TacheFormComponent implements OnInit {
  @Input() projetId?: number;
  tacheForm: FormGroup;

  constructor(private fb: FormBuilder, private tacheService: TacheService) {
    this.tacheForm = this.fb.group({
      nom: ['', Validators.required],
      description: [''],
      dateEcheance: [''],
      priorite: [''],
      projet: [null],
    });
  }

  ngOnInit() {
    if (this.projetId) {
      this.tacheForm.patchValue({ projet: { id: this.projetId } });
    }
  }

  onSubmit() {
    if (this.tacheForm.valid) {
      this.tacheService.creerTache(this.tacheForm.value).subscribe({
        next: () => {
          alert('Tâche enregistrée');
          this.tacheForm.reset();
        },
        error: () => {
          alert('Erreur lors de la sauvegarde');
        },
      });
    }
  }
}
