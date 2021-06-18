package home.jurufola.entites;

import javax.persistence.*;
import java.util.List;

/**
 * Classe Banque
 * @author juruf_000
 */
@Entity
@Table(name = "banque")
public class Banque {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom")
    private String nom;

    @OneToMany(mappedBy = "banque")
    private List<Client> clients;

    /**
     * Constructeur
     * @param nom
     * @param clients
     */
    public Banque(String nom, List<Client> clients) {
        this.nom = nom;
        this.clients = clients;
    }

    /**
     * Constructeur Vide
     */
    public Banque() {

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
     * Getteur liste clients
     * @return
     */
    public List<Client> getClients() {
        return clients;
    }

    /**
     * Setteur liste clients
     * @param clients
     */
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    /**
     * Redefinition toString()
     * @return Une chaîne de caractère avec la description de la banque
     */
    @Override
    public String toString() {
        return "Banque{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", clients=" + clients +
                '}';
    }
}
