package home.jurufola.entites;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Classe Client
 * @author juruf_000
 */
@Entity
@Table(name = "client")
public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @ManyToOne
    @JoinColumn(name = "id_banque")
    private Banque banque;

    @Embedded
    private Adresse adresse;

    @ManyToMany
    @JoinTable(name="client_compte",
            joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id"))
    private List<Compte> comptes;

    /**
     * Constructeur
     * @param nom Le nom du client
     * @param prenom Le prénom du client
     * @param dateNaissance  La date de naissance du client
     * @param banque La banque du client
     * @param adresse L'adresse du client
     * @param comptes Les différents comptes du client
     */
    public Client(String nom, String prenom, LocalDate dateNaissance, Banque banque, Adresse adresse, List<Compte> comptes) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.banque = banque;
        this.adresse = adresse;
        this.comptes = comptes;
    }

    /**
     * Constructeur vide
     */
    public Client() {

    }

    /**
     * Getteur id
     * @return l'id du client
     */
    public int getId() {
        return id;
    }

    /**
     * Setteur id
     * @param id L'id du client
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getteur nom
     * @return Le nom du client
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setteur nom
     * @param nom Le nom du client
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getteur prenom
     * @return Le prénom du client
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Setteur prenom
     * @param prenom Le prénom du client
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Getteur date de naissance
     * @return La date de niassance du client
     */
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Setteur date de naissance
     * @param dateNaissance La date de naissance ud client
     */
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * Getteur banque
     * @return La banque du client
     */
    public Banque getBanque() {
        return banque;
    }

    /**
     * Setteur banque
     * @param banque La banque du client
     */
    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    /**
     * Getteur adresse
     * @return L'adresse du client
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Setteur adresse
     * @param adresse L'adresse du client
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    /**
     * Getteur liste comptes
     * @return La liste des comptes du client
     */
    public List<Compte> getComptes() {
        return comptes;
    }

    /**
     * Setteur liste comptes
     * @param comptes La liste des comptes du client
     */
    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    /**
     * Redefinition toString()
     * @return Une chaîne de caractère avec la description deu client
     */
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", banque=" + banque +
                ", adresse=" + adresse +
                ", comptes=" + comptes +
                '}';
    }
}
