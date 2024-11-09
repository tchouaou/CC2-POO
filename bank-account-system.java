// Classe pour représenter un client
class Client {
    private String nom;
    private String ville;
    private CompteBancaire comptePrive;
    private CompteBancaire compteEpargne;

    public Client(String nom, String ville, double soldeComptePrivé, double soldeCompteEpargne) {
        this.nom = nom;
        this.ville = ville;
        this.comptePrive = new CompteBancaire(soldeComptePrivé, 0.01); // taux1 = 0.01
        this.compteEpargne = new CompteBancaire(soldeCompteEpargne, 0.02); // taux2 = 0.02
    }

    public  static void calculerInterets() {
        comptePrive.calculerInteret();
        compteEpargne.calculerInteret();
    }

    public void afficherComptes() {
        System.out.println("Client " + nom + " de " + ville);
        System.out.println("Compte privé: " + String.format("%.1f", comptePrive.getSolde()) + " francs");
        System.out.println("Compte d'épargne: " + String.format("%.1f", compteEpargne.getSolde()) + " francs");
    }
}

// Classe pour représenter un compte bancaire
class CompteBancaire {
    private double solde;
    private double tauxInteret;

    public CompteBancaire(double soldeInitial, double tauxInteret) {
        this.solde = soldeInitial;
        this.tauxInteret = tauxInteret;
    }

    public void calculerInteret() {
        solde += solde * tauxInteret;
    }

    public double getSolde() {
        return solde;
    }
}

// Classe principale
public class Banque1 {
    public static void main(String[] args) {
        // Création des clients
        Client client1 = new Client("Pedro", "Geneve", 1000.0, 2000.0);
        Client client2 = new Client("Alexandra", "Lausanne", 3000.0, 4000.0);

        // Affichage des données avant le bouclement
        System.out.println("Données avant le bouclement des comptes:");
        client1.afficherComptes();
        client2.afficherComptes();

        // Calcul des intérêts
        client1.calculerInterets();
        client2.calculerInterets();

        // Affichage des données après le bouclement
        System.out.println("\nDonnées après le bouclement des comptes:");
        client1.afficherComptes();
        client2.afficherComptes();
    }
}
