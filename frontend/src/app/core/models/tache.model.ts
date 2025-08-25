import { Projet } from './projet.model';
import { Utilisateur } from './utilisateur.model';

export interface Tache {
  id?: number;
  nom: string;
  description: string;
  dateEcheance?: string;
  priorite?: string;
  statut?: string;
  dateFin?: string;
  projet?: Projet;
  utilisateursAssignes?: Utilisateur[];
}
