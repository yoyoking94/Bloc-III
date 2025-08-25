import { Utilisateur } from './utilisateur.model';

export interface Projet {
  id?: number;
  nom: string;
  description: string;
  dateDebut: string;
  createur?: Utilisateur;
}
