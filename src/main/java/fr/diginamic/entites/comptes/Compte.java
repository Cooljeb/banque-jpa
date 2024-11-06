package fr.diginamic.entites.comptes;

import fr.diginamic.entites.identites.Client;
import fr.diginamic.entites.operations.Operation;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe de compte principale
 */
@Entity
@Table(name = "COMPTE")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE_DE_COMPTE")
public class Compte implements Serializable {

    // Attributs d'instance
    /**ID cu compte**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMPTE")
    private Integer id;

    /**nom du compte**/
    @Column(name="NUMERO_COMPTE", length =50, nullable = false)
    private String numero;

    /**solde du compte**/
    @Column(name="SOLDE", length =50, nullable = false)
    private double solde = 0.00d;

    /**Lien vers les clients*/
    @ManyToMany
    @JoinTable(name="COMPTE_CLIENT",
            joinColumns = @JoinColumn(name = "ID_CLI", referencedColumnName ="ID_CLIENT" ),
            inverseJoinColumns =@JoinColumn(name ="ID_CPTE", referencedColumnName ="ID_COMPTE")
    )
    private Set<Client>clients;

    /**Lien vers les opérations effectuées sur le compte*/
    @OneToMany(mappedBy = "compte")
    private Set<Operation> operations;

    /**Constructeur**/
    public Compte() {
        clients = new HashSet<Client>();
        operations = new HashSet<Operation>();
    }

    //Getters et Setters

    /**
     * Getter
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter
     *
     * @return nom
     */
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Getter
     *
     * @return solde
     */
    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    /**
     * Getter
     *
     * @return clients
     */
    public Set<Client> getClients() {
        return clients;
    }

    /**
     * Setter
     *
     * @param clients
     **/
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    /**
     * Getter
     *
     * @return operations
     */
    public Set<Operation> getOperations() {
        return operations;
    }

    /**
     * Setter
     *
     * @param operations
     **/
    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Compte{");
        sb.append("id=").append(id);
        sb.append(", numero='").append(numero).append('\'');
        sb.append(", solde=").append(solde);
        sb.append('}');
        return sb.toString();
    }
}
