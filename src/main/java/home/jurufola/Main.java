package home.jurufola;

import home.jurufola.entites.*;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Classe exécutable
 * @author juruf_000
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("banque");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction et = manager.getTransaction();
        et.begin();

        /*** TP 4 ***/

        //Creation Banque

        Banque banque = new Banque("BMS", new ArrayList<>());
        manager.persist(banque);

        //Creation Clients

        Client client1 = new Client("HAÏDARA", "Moulaye", LocalDate.of(1980, 9, 28), banque, new Adresse(298, "rue de la ville", 75000, "Paris"), new ArrayList<>());
        Client client2 = new Client("HAÏDARA", "MAny", LocalDate.of(1982, 2, 8), banque, new Adresse(298, "rue de la ville", 75000, "Paris"), new ArrayList<>());
        manager.persist(client1);
        manager.persist(client2);
        //Création Comptes

        Compte compte = new Compte("123456", 5000.0, new ArrayList<>(),  Arrays.asList(client1, client2));
        manager.persist(compte);
        //Laison clients et banque
        banque.setClients(Arrays.asList(client1, client2));




        /*** TP 5 ***/

        //Creation AssuranceVie et LivretA
        AssuranceVie assuranceVie = new AssuranceVie("234567", 100_000.0, new ArrayList<>(), new ArrayList<>(), LocalDate.of(2030, 12, 31), .02);
        LivretA livretA = new LivretA("345678", 5000.0, new ArrayList<>(), new ArrayList<>(), 0.01);
        manager.persist(assuranceVie);
        manager.persist(livretA);

        // Creation nouveau client avec une assurance Vie et un Livret A
        Client client3 = new Client("HAÏDARA", "Aman", LocalDate.of(2012, 8, 25), banque, new Adresse(298, "rue de la ville", 75000, "Paris"), Arrays.asList(assuranceVie, livretA));
        manager.persist(client3);

        //Creation Operation de retrait sur le premier compte
        Operation operation = new Operation(LocalDate.now(), -100.0, "retrait 100 euro", compte);
        manager.persist(operation);

        //Virement à partir  du livret A et de l 'assurance Vie
        Virement virementLivretA = new Virement(LocalDate.now(), 1000.0, "Virement 1000 à Papa", livretA, "Papa");
        Virement virementAssVie = new Virement(LocalDate.now(), 20_000.0, "Virement 20_000 à Papa", assuranceVie, "Papa");
        manager.persist(virementLivretA);
        manager.persist(virementAssVie);

        //Affichage LivretA et AssuranceVie pour verifier le debit
        System.out.println("Nouveau solde LivretA " + livretA.getSolde());
        System.out.println("Nouveau solde AssuranceVie " + assuranceVie.getSolde());

        et.commit();
        manager.close();
        factory.close();

    }
}
