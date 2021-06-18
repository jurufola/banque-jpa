package home.jurufola.entites;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Classe Operation
 * @author juruf_000
 */

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
     * @param date La date de l'opération
     * @param montant Le montant de l'opération
     * @param motif Le motif de l'opération
     * @param compte Le compte associé
     */
    public Operation(LocalDate date, double montant, String motif, Compte compte) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
        this.compte = compte;
        //Mise à jour solde dans le compte
        if(compte.getSolde() < montant){
            System.out.println("Montant solde insuffissant Vous ne pouvez pas debiter un montant de plus de " + compte.getSolde());
            compte.setSolde(0.0);
            System.out.println("Vous avez été débité de la totalité de votre solde! Merci de provisionner le compte avant toute opération");
        }else compte.setSolde(compte.getSolde() + montant);
    }

    /**
     * Constructeur vide
     */
    public Operation() {
    }

    /**
     * Getteur id
     * @return L'id
     */
    public int getId() {
        return id;
    }

    /**
     * Setteur id
     * @param id L'id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getteur date
     * @return La date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Setteur date
     * @param date La date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Getteur montant
     * @return Le montant
     */
    public double getMontant() {
        return montant;
    }

    /**
     * Setteur montant
     * @param montant Le montant
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }

    /**
     * Getteur motif
     * @return Le motif
     */
    public String getMotif() {
        return motif;
    }

    /**
     * Setteur motif
     * @param motif Le motif
     */
    public void setMotif(String motif) {
        this.motif = motif;
    }

    /**
     * getteur compte
     * @return Le compte
     */
    public Compte getCompte() {
        return compte;
    }

    /**
     * Setteur compte
     * @param compte Le compte
     */
    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    /**
     * Redefinition toString()
     * @return Une chaîne de caractère avec la description de l'opération
     */
    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", date=" + date +
                ", montant=" + montant +
                ", motif='" + motif + '\'' +
                ", compte=" + compte +
                '}';
    }
}
