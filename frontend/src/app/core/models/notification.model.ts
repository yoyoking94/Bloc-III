import { Utilisateur } from './utilisateur.model';

export interface Notification {
  id?: number;
  utilisateur: Utilisateur;
  message: string;
  dateNotification: string;
}
