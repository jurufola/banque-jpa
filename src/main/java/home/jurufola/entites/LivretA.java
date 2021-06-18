package home.jurufola.entites;

import javax.persistence.*;
import java.util.List;

/**
 * Classe LivretA
 * @author juruf_000
 */
@Entity
@Table(name = "livretA")
public class LivretA extends Compte{
    @Column(name = "taux")
    private double taux;

    /**
     * Constructeur
     *
     * @param numero Le numero de compte
     * @param solde Le solde
     * @param operations La liste des opérations
     * @param clients La liste des clients
     */
    public LivretA(String numero, double solde, List<Operation> operations, List<Client> clients, double taux) {
        super(numero, solde, operations, clients);
        this.taux = taux;
    }

    /**
     * Constructeur vide
     */
    public LivretA() {
    }

    /**
     * Getteur taux
     * @return Le taux
     */
    public double getTaux() {
        return taux;
    }

    /**
     * Setteur taux
     * @param taux Le taux
     */
    public void setTaux(double taux) {
        this.taux = taux;
    }

    /**
     * Redefinition toString()
     * @return Une chaîne de caractère avec la description du livretA
     */
    @Override
    public String toString() {
        return "LivretA{" +
                "taux=" + taux +
                '}';
    }
}
