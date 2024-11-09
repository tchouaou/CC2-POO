public class Banque2 {
    public static void main(String[] args) {
        // Données pour le premier client (nom et ville)
        String nom1 = "Pedro";
        String ville1 = "Geneve";
        // Données pour le compte privé du premier client (solde)
        double solde1PremierClient = 1000.0;
        // Données pour le compte d'épargne du premier client (solde)
        double solde2PremierClient = 2000.0;

        // Données pour le deuxième client (nom et ville)
        String nom2 = "Alexandra";
        String ville2 = "Lausanne";
        // Données pour le compte privé du deuxième client (solde)
        double solde1DeuxiemeClient = 3000.0;
        // Données pour le compte d'épargne du deuxième client (solde)
        double solde2DeuxiemeClient = 4000.0;

        // Afficher les données du premier client
        afficherClient(nom1, ville1, solde1PremierClient, solde2PremierClient);
        // Afficher les données du deuxième client
        afficherClient(nom2, ville2, solde1DeuxiemeClient, solde2DeuxiemeClient);

        System.out.println("\nDonnées après le bouclement des comptes:");

        // Bouclement du compte privé du premier client
        solde1PremierClient = bouclerCompte(solde1PremierClient, 0.01);
        // Bouclement du compte d'épargne du premier client
        solde2PremierClient = bouclerCompte(solde2PremierClient, 0.02);
        // Bouclement du compte privé du deuxième client
        solde1DeuxiemeClient = bouclerCompte(solde1DeuxiemeClient, 0.01);
        // Bouclement du compte d'épargne du deuxième client
        solde2DeuxiemeClient = bouclerCompte(solde2DeuxiemeClient, 0.02);

        // Afficher les données du premier client
        afficherClient(nom1, ville1, solde1PremierClient, solde2PremierClient);
        // Afficher les données du deuxième client
        afficherClient(nom2, ville2, solde1DeuxiemeClient, solde2DeuxiemeClient);
    }

    static void afficherClient(String nom, String ville, double solde1, double solde2) {
        System.out.println("Client " + nom + " de " + ville);
        System.out.println("Compte privé: " + solde1 + " francs");
        System.out.println("Compte d'épargne: " + solde2 + " francs");
    }

    static double bouclerCompte(double solde, double taux) {
        // Cette méthode ajoute les intérêts au solde
        double interets = taux * solde;
        double nouveauSolde = solde + interets;
        return nouveauSolde;
    }
}
