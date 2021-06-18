package home.jurufola.entites;

import javax.persistence.*;

/**
 * Classe Adresse
 * @author juruf_000
 */
@Embeddable
public class Adresse {

    @Column(name = "numero")
    private int numero;

    @Column(name = "rue")
    private String rue;

    @Column(name = "code_postal")
    private int codePostal;

    @Column(name = "ville")
    private String ville;

    /**
     *
     * @param numero Le numero de la rue
     * @param rue La rue
     * @param codePostal Le code postal
     * @param ville La ville
     */

    public Adresse(int numero, String rue, int codePostal, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    /**
     * Constructeur vide
     */
    public Adresse() {
    }

    /**
     * Getteur numero
     * @return Le numéro
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Setteur numéro
     * @param numero Le numéro
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Getteur rue
     * @return La rue
     */
    public String getRue() {
        return rue;
    }

    /**
     * Setteur rue
     * @param rue La rue
     */
    public void setRue(String rue) {
        this.rue = rue;
    }

    /**
     * Getteur code postal
     * @return Le code postal
     */
    public int getCodePostal() {
        return codePostal;
    }

    /**
     * Setteur code postal
     * @param codePostal Le code postal
     */
    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * Getteur ville
     * @return La ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * Setteur ville
     * @param ville La ville
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * Redefinition toString()
     * @return Une chaîne de caractère avec la description de l'adresse
     */
    @Override
    public String toString() {
        return "Adresse{" +
                "numero=" + numero +
                ", rue='" + rue + '\'' +
                ", codePostal=" + codePostal +
                ", ville='" + ville + '\'' +
                '}';
    }
}
