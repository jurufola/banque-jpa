package home.jurufola.entites;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "livretA")
public class LivretA extends Compte{
    @Column(name = "taux")
    private double taux;

    /**
     * Constructeur
     *
     * @param numero
     * @param solde
     * @param operations
     * @param clients
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
     * @return
     */
    public double getTaux() {
        return taux;
    }

    /**
     * Setteur taux
     * @param taux
     */
    public void setTaux(double taux) {
        this.taux = taux;
    }
}
