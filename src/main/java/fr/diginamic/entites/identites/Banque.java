package fr.diginamic.entites.identites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Entité Banque
 */
@Entity
@Table(name = "BANQUE")
public class Banque implements Serializable {

    /**ID de la banque**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BANQUE")
    private Integer id;

    /**Nom de la banque**/
    @Column(name="NOM", length =50, nullable = false)
    private String banque;

    /**Liste des clients de la banque*/
    @OneToMany(mappedBy = "banque")
    private Set<Client> clients;

    /**Constructeur de la banque**/
    public Banque() {
        clients = new HashSet<Client>();
    }

    // Getters et Setters
    /**
     * Getter
     * @return banque
     */
    public String getBanque() {
        return banque;
    }

    /**
     * Setter#
     * @param
     */
    public void setBanque(String banque) {
        this.banque = banque;
    }

    /**
     * Getter
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter#
     *
     * @param
     */
    public void setId(Integer id) {
        this.id = id;
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
     * Setter#
     *
     * @param clients
     **/
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    /**
     * Méthode ToString
     */
    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Banque{");
        sb.append("id=").append(id);
        sb.append(", banque='").append(banque).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
