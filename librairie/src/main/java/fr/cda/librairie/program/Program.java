package fr.cda.librairie.program;

import fr.cda.librairie.entity.Commande;
import fr.cda.librairie.entity.Livre;
import fr.cda.librairie.entity.User;

public class Program {
    public static void main(String[] args) {
         User user = new User("Fethi", "Benseddik");
        Commande commande = new Commande();
        Livre livre  =  new Livre();
        Livre livre1 = new Livre();
        commande.getListLivre().add(livre);
        commande.getListLivre().add(livre1);
        user.getCommandes().add(commande);

    }
}
