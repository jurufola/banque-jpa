package home.jurufola.entites;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "operation")
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "montant")
    private double montant;

    @Column(name = "motif")
    private String motif;

    @ManyToOne
    @JoinColumn(name = "id_compte")
    private Compte compte;

    /**
     * constructeur
     * @param date
     * @param montant
     * @param motif
     * @param compte
     */
    public Operation(LocalDate date, double montant, String motif, Compte compte) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
        this.compte = compte;
    }

    /**
     * Constructeur vide
     */
    public Operation() {
    }

    /**
     * Getteur id
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Setteur id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getteur date
     * @return
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Setteur date
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Getteur montant
     * @return
     */
    public double getMontant() {
        return montant;
    }

    /**
     * Setteur montant
     * @param montant
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }

    /**
     * Getteur motif
     * @return
     */
    public String getMotif() {
        return motif;
    }

    /**
     * Setteur motif
     * @param motif
     */
    public void setMotif(String motif) {
        this.motif = motif;
    }

    /**
     * getteur compte
     * @return
     */
    public Compte getCompte() {
        return compte;
    }

    /**
     * Setteur compte
     * @param compte
     */
    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
