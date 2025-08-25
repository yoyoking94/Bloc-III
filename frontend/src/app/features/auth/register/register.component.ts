import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { UtilisateurService } from '../../../core/services/utilisateur.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-register',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './register.component.html'
})
export class RegisterComponent {
  registerForm: FormGroup;

  constructor(private fb: FormBuilder, private utilisateurService: UtilisateurService) {
    this.registerForm = this.fb.group({
      nomUtilisateur: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      motDePasse: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.registerForm.valid) {
      this.utilisateurService.inscrire(this.registerForm.value).subscribe({
        next: res => { alert('Inscription réussie'); this.registerForm.reset(); },
        error: err => { alert('Erreur lors de l\'inscription'); }
      });
    }
  }
}
