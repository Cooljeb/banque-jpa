package fr.diginamic.entites.identites;

import fr.diginamic.entites.comptes.Compte;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * Classe des clients
 * Mappage effectué pour générer la table éponyme dnans la bdd banque
 */
@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

    /** Id du client**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENT")
    private Integer id;

    /**Nom du client**/
    @Column(name="NOM", length =50, nullable = false)
    private String nom;

    /**Prénom du client **/
    @Column(name="PRENOM", length =50, nullable = false)
    private String prenom;

    /**date de naissance du client**/
    @Column(name = "DATE_NAISSANCE", nullable = false)
    private LocalDate dateNaissance;

    /**Adresse du client**/
    @Embedded
    @Column(name = "ADRESSE",length = 255, nullable = false)
    private Adresse adresse;

    /**lien vers la banque du client**/
    @ManyToOne
    @JoinColumn(name = "ID_BANQUE")
    private Banque banque;

    /**Lien vers le/les compte(s) des clients**/
    @ManyToMany
    @JoinTable(name="COMPTE_CLIENT",
        joinColumns =@JoinColumn(name ="ID_CPTE", referencedColumnName ="ID_COMPTE"),
        inverseJoinColumns = @JoinColumn(name = "ID_CLI", referencedColumnName ="ID_CLIENT" )
    )
    private Set<Compte> comptes;


    /**Constructeur**/
    public Client() {
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
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter
     *
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Getter
     *
     * @return dateNaissance
     */
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * Getter
     *
     * @return adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Setter#
     *
     * @param adresse
     **/
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", dateNaissance=").append(dateNaissance);
        sb.append(", adresse=").append(adresse);
        sb.append(", banque=").append(banque);
        sb.append('}');
        return sb.toString();
    }
}
