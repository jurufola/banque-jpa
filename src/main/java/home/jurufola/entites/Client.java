package home.jurufola.entites;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @param banque
     * @param adresse
     * @param comptes
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
     * Getteur nom
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setteur nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getteur prenom
     * @return
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Setteur prenom
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Getteur date de naissance
     * @return
     */
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Setteur date de naissance
     * @param dateNaissance
     */
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * Getteur banque
     * @return
     */
    public Banque getBanque() {
        return banque;
    }

    /**
     * Setteur banque
     * @param banque
     */
    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    /**
     * Getteur adresse
     * @return
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Setteur adresse
     * @param adresse
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    /**
     * Getteur liste comptes
     * @return
     */
    public List<Compte> getComptes() {
        return comptes;
    }

    /**
     * Setteur liste comptes
     * @param comptes
     */
    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }
}
