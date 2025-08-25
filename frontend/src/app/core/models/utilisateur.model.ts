export interface Utilisateur {
    id?: number;
    nomUtilisateur: string;
    email: string;
    motDePasse?: string; // Facultatif pour éviter d’exposer le mot de passe côté client
  }
  