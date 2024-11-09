// Classe représentant un client de la banque
class Client {
    private String nom;
    private String ville;
    private CompteBancaire comptePrivé;
    private ComptePargne compteEpargne;

    public Client(String nom, String ville) {
        this.nom = nom;
        this.ville = ville;
    }

    public void setComptePrivé(CompteBancaire comptePrivé) {
        this.comptePrivé = comptePrivé;
    }

    public void setCompteEpargne(ComptePargne compteEpargne) {
        this.compteEpargne = compteEpargne;
    }

    public String getNom() {
        return nom;
    }

    public String getVille() {
        return ville;
    }

    public void afficherComptes() {
        System.out.println("Client: " + nom + " (" + ville + ")");
        if (comptePrivé != null) {
            System.out.println("Compte privé: " + comptePrivé.getSolde() + "€");
        }
        if (compteEpargne != null) {
            System.out.println("Compte épargne: " + compteEpargne.getSolde() + "€");
        }
    }
}

// Classe abstraite représentant un compte bancaire
abstract class CompteBancaire {
    protected double solde;
    protected double tauxInteret;

    public CompteBancaire(double soldeInitial, double tauxInteret) {
        this.solde = soldeInitial;
        this.tauxInteret = tauxInteret;
    }

    public double getSolde() {
        return solde;
    }

    public void depot(double montant) {
        if (montant > 0) {
            solde += montant;
        }
    }

    public boolean retrait(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            return true;
        }
        return false;
    }

    public abstract void appliquerInteret();
}

// Classe représentant un compte privé
class ComptePrivé extends CompteBancaire {
    public ComptePrivé(double soldeInitial, double tauxInteret) {
        super(soldeInitial, tauxInteret);
    }

    @Override
    public void appliquerInteret() {
        solde += solde * tauxInteret;
    }
}

// Classe représentant un compte épargne
class ComptePargne extends CompteBancaire {
    public ComptePargne(double soldeInitial, double tauxInteret) {
        super(soldeInitial, tauxInteret);
    }

    @Override
    public void appliquerInteret() {
        solde += solde * tauxInteret;
    }
}

// Classe principale représentant la banque
class Banque {
    private static final int MAX_CLIENTS = 2;
    private Client[] clients;
    private int nombreClients;

    public Banque() {
        clients = new Client[MAX_CLIENTS];
        nombreClients = 0;
    }

    public void ajouterClient(Client client, double soldeInitialPrivé, double soldeInitialEpargne) {
        if (nombreClients < MAX_CLIENTS) {
            clients[nombreClients] = client;
            
            // Création des comptes avec des taux d'intérêt différents
            CompteBancaire comptePrivé = new ComptePrivé(soldeInitialPrivé, 0.02); // 2% d'intérêt
            ComptePargne compteEpargne = new ComptePargne(soldeInitialEpargne, 0.04); // 4% d'intérêt
            
            client.setComptePrivé(comptePrivé);
            client.setCompteEpargne(compteEpargne);
            
            nombreClients++;
        }
    }

    public void afficherTousLesComptes() {
        for (int i = 0; i < nombreClients; i++) {
            clients[i].afficherComptes();
            System.out.println("--------------------");
        }
    }
}

// Programme principal pour tester
public class Banque2 {
    public static void main(String[] args) {
        Banque banque = new Banque();
        
        // Création des clients avec leurs comptes
        Client client1 = new Client("Pedro", "Paris");
        Client client2 = new Client("Alexandra", "Lyon");
        
        banque.ajouterClient(client1, 1000, 2000);
        banque.ajouterClient(client2, 1500, 3000);
        
        // Affichage de tous les comptes
        banque.afficherTousLesComptes();
    }
}
