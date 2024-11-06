package fr.diginamic.entites.comptes;

import jakarta.persistence.*;

import java.io.Serializable;

/**Classe du Livret A**/
@Entity
@Table(name = "LIVRET_A")
@DiscriminatorValue("LA")
public class LivretA extends Compte implements Serializable  {

    //Attribut d'instance

    /**ID du livret A */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LIVRET_A")
    private Integer id;

    /**Taux de rémunération**/
    @Column(name = "TAUX", nullable = false)
    private double taux;

    /**Constructeur**/
    public LivretA() {
        super();
    }

    //Getter et Setter

    /**
     * Getter
     * @return taux
     */
    public double getTaux() {
        return taux;
    }

    /**
     * Setter
     * @param taux
     */
    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("LivretA{");
        sb.append("id=").append(id);
        sb.append(", taux=").append(taux);
        sb.append('}');
        return sb.toString();
    }
}
