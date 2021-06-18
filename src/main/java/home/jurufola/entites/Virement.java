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
     * @param date  La date
     * @param montant Le montant
     * @param motif Le motif
     * @param compte Le compte
     */
    public Virement(LocalDate date, double montant, String motif, Compte compte, String beneficiaire) {
        super(date, -montant, motif, compte);
        this.beneficiaire = beneficiaire;
    }

    /**
     * Constructeur vide
     */
    public Virement() {
    }

    /**
     * Getteur bénéficiaire
     * @return Le bénéficiaire
     */
    public String getBeneficiaire() {
        return beneficiaire;
    }

    /**
     * Setteur bébéficiaire
     * @param beneficiaire Le bénéficiaire
     */
    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    /**
     * Redefinition toString()
     * @return Une chaîne de caractère avec la description du virement
     */
    @Override
    public String toString() {
        return "Virement{" +
                "beneficiaire='" + beneficiaire + '\'' +
                '}';
    }
}
