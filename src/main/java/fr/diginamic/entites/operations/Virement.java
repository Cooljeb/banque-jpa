package fr.diginamic.entites.operations;

import jakarta.persistence.*;

/**
 * Classe des opétations de type virement
 */
@Entity
@Table(name = "VIREMENT")
@DiscriminatorValue("V")
public class Virement extends Operation{

    //Atributs de classe

    /**ID du virement*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VIREMENT")
    private Integer id;

    /**bénéficiaire*/
    @Column(name = "BENEFICIAIRE", length = 100, nullable = false)
     private String beneficiaire;

     /**Constructeur*/

    public Virement() {
        super();
    }

    //Getter et Setter

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
     *
     * @return beneficiaire
     */
    public String getBeneficiaire() {
        return beneficiaire;
    }

    /**
     * Setter
     *
     * @param beneficiaire
     **/
    public void setBenediciaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Virement{");
        sb.append("id=").append(id);
        sb.append(", beneficiaire='").append(beneficiaire).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
