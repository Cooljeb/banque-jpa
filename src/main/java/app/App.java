package app;

import fr.diginamic.entites.comptes.AssuranceVie;
import fr.diginamic.entites.comptes.Compte;
import fr.diginamic.entites.comptes.LivretA;
import fr.diginamic.entites.identites.Adresse;
import fr.diginamic.entites.identites.Banque;
import fr.diginamic.entites.identites.Client;
import fr.diginamic.entites.operations.Operation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe principale de l'application
 */
public class App {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Set <Client> mesClients = new HashSet<Client>();
        Set<Operation> mesOperations= new HashSet<Operation>();

        //Création d'une banque
        Banque b = new Banque();
        b.setBanque("Crédit Agricole");
        em.persist(b);

        //Création d'une adresse
        Adresse a =  new Adresse();
        a.setNumero(75);
        a.setRue("rue de la paix");
        a.setCodePostal(44120);
        a.setVille("VERTOU");

        //Création d'un client
        Client c= new Client();
        c.setNom("BROU");
        c.setPrenom("Joseph");
        c.setDateNaissance(LocalDate.of(1987,10,31));
        c.setAdresse(a);
        mesClients.add(c);
        em.persist(c);

        //Création d'un compte Livret A
        LivretA la = new LivretA() ;
        la.setNumero("1459");
        la.setSolde(1);
        la.setTaux(1.25);
        la.setClients(mesClients);
        em.persist(la);

        //Création d'un compte Assurance vie

        AssuranceVie av = new AssuranceVie();
        av.setNumero("1560");
        av.setSolde(500);
        av.setTaux(5.00);
        av.setClients(mesClients);
        av.setDateFin(LocalDate.of(2035,10,31));
        em.persist(av);

        //Création d'une opération

        Operation ope = new Operation();
        ope.setDate(LocalDate.now());
        ope.setCompte(la);
        ope.setMontant(500);
        ope.setMotif("Don de la française des jeux");
        mesOperations.add(ope);
        em.persist(ope);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
