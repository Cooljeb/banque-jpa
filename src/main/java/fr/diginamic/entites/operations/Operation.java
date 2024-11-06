package fr.diginamic.entites.operations;

import fr.diginamic.entites.comptes.Compte;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/***
 * Classe des opérations bancaires
 */
@Entity
@Table(name = "OPERATION")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE_OPERATION")
public class Operation implements Serializable {

    /**ID de l'opération**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_OPERATION")
    private Integer id;

    /**date de l'opération**/
    @Column(name = "DATE",nullable = false)
    private LocalDate date;

    /**Montant de l'opération**/
    @Column(name = "MONTANT", nullable = false)
    private double montant = 0.00d;

    /**Motif de l'opération**/
    @Column(name = "MOTIF",length =50, nullable = false)
    private String motif;

    /**Lien vers le compte lié à l'opération*/
    @ManyToOne
    @JoinColumn(name = "ID_CPTE")
    private Compte compte;

    /**Constructeur de la classe**/
    public Operation() {
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
     * @return date
     */
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Getter
     *
     * @return montant
     */
    public double getMontant() {
        return montant;
    }

    /**
     * Setter
     * @param montant
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }

    /**
     * Getter
     *
     * @return motif
     */
    public String getMotif() {
        return motif;
    }

    /**
     * Setter
     * @param motif
     */
    public void setMotif(String motif) {
        this.motif = motif;
    }

    /**
     * Getter
     *
     * @return compte
     */
    public Compte getCompte() {
        return compte;
    }

    /**
     * Setter
     *
     * @param compte
     **/
    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
