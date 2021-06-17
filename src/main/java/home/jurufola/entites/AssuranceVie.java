package home.jurufola.entites;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
     * @param numero
     * @param solde
     * @param operations
     * @param clients
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
     * @return
     */
    public LocalDate getDateFin() {
        return dateFin;
    }

    /**
     * Setteur date de fin
     * @param dateFin
     */
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
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
