package home.jurufola.entites;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "virement")
public class Virement extends Operation{

    @Column(name = "beneficiaire")
    private String beneficiaire;

    /**
     * Constructeur
     *
     * @param date
     * @param montant
     * @param motif
     * @param compte
     */
    public Virement(LocalDate date, double montant, String motif, Compte compte, String beneficiaire) {
        super(date, montant, motif, compte);
        this.beneficiaire = beneficiaire;
    }

    /**
     * Constructeur vide
     */
    public Virement() {
    }

    /**
     * Getteur bénéficiaire
     * @return
     */
    public String getBeneficiaire() {
        return beneficiaire;
    }

    /**
     * Setteur bébéficiaire
     * @param beneficiaire
     */
    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}
