package fr.diginamic.entites.comptes;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;


/**
 * Classe représentant l'assurance vie
 */
@Entity
@Table(name = "ASSURANCE_VIE")
@DiscriminatorValue("AV")
public class AssuranceVie extends Compte implements Serializable {

    // Attributs

    /**ID de l'assurance vie*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ASSURANCE_VIE")
    private Integer id;

    /**Date de fin de l'assurance vie**/
    @Column(name = "DATE_DE_FIN", nullable = false)
    private LocalDate dateFin;

    /**Taux de rémunération de l'assurance Vie**/
    @Column(name ="TAUX", nullable = false)
    private double taux;

    /**Constructeur**/

    public AssuranceVie() {
        super();
    }

    //Getters et Setters

    /**
     * Getter
     *
     * @return id
     */
    @Override public Integer getId() {
        return id;
    }

    /**
     * Setter
     *
     * @param id
     **/
    @Override public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter

     * @return dateFin
     */
    public LocalDate getDateFin() {
        return dateFin;
    }

    /**
     * Getter

     * @return taux
     */
    public double getTaux() {
        return taux;
    }

    /**
     * Setter#

     * @param taux
     */
    public void setTaux(double taux) {
        this.taux = taux;
    }

    /**
     * Setter#
     * @param dateFin
     */
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("AssuranceVie{");
        sb.append("id=").append(id);
        sb.append(", dateFin=").append(dateFin);
        sb.append(", taux=").append(taux);
        sb.append('}');
        return sb.toString();
    }
}
