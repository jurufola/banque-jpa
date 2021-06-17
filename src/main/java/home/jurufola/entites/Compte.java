package home.jurufola.entites;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "compte")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "numero")
    private String numero;

    @Column(name = "solde")
    private double solde;

    @OneToMany(mappedBy = "compte")
    private List<Operation> operations;

    @ManyToMany
    @JoinTable(name="client_compte",
            joinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"))
    private List<Client> clients;

    /**
     * Constructeur
     * @param numero
     * @param solde
     * @param operations
     * @param clients
     */
    public Compte(String numero, double solde, List<Operation> operations, List<Client> clients) {
        this.numero = numero;
        this.solde = solde;
        this.operations = operations;
        this.clients = clients;
    }

    /**
     * Constructeur vide
     */
    public Compte() {
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
     * Getteur numéro
     * @return
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Setteur numéro
     * @param numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Getteur solde
     * @return
     */
    public double getSolde() {
        return solde;
    }

    /**
     * Setteur solde
     * @param solde
     */
    public void setSolde(double solde) {
        this.solde = solde;
    }

    /**
     * Getteur liste opérations
     * @return
     */
    public List<Operation> getOperations() {
        return operations;
    }

    /**
     * Setteur liste opérations
     * @param operations
     */
    public void setOperations(List<Operation> operations) {
        this.operations = operations;
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
}
