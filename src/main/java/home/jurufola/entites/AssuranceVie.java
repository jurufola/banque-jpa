package home.jurufola.entites;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Classe AssuranceVie
 * @author juruf_000
 */
@Entity
@Table(name = "assuranceVie")
public class AssuranceVie extends Compte {

    @Column(name = "date_fin")
    private LocalDate dateFin;

    @Column(name = "taux")
    private double taux;

    /**
     * Constructeur
     *
     * @param numero Le numéro de compte
     * @param solde Le solde
     * @param operations La liste des opérations
     * @param clients La liste des clients
     */
    public AssuranceVie(String numero, double solde, List<Operation> operations, List<Client> clients, LocalDate dateFin, double taux) {
        super(numero, solde, operations, clients);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    /**
     * Constructeur vide
     */
    public AssuranceVie() {

    }

    /**
     * Getteur date de fin
     * @return La date de fin
     */
    public LocalDate getDateFin() {
        return dateFin;
    }

    /**
     * Setteur date de fin
     * @param dateFin La date de fin
     */
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
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
     * @return Une chaîne de caractère avec la description de l'assuranceVie
     */
    @Override
    public String toString() {
        return "AssuranceVie{" +
                "dateFin=" + dateFin +
                ", taux=" + taux +
                '}';
    }
}
