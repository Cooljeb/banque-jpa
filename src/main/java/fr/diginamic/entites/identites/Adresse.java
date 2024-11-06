package fr.diginamic.entites.identites;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**Classe Adresse, <br> qui n'aura pas d'existence propre, mais vivra à travers Client**/
@Embeddable
public class Adresse  {

   /**numéro de l'adresse**/
   @Column(name ="NUMERO", length = 5)
   private Integer numero;

   /**rue**/
   @Column(name = "RUE", length = 200)
   private String rue;

   /**Code Postal**/
   @Column(name = "CODE_POSTAL", length = 5)
   private int codePostal;

   /**Ville**/
   @Column(name="VILLE", length = 70)
   private String ville;


   /**
    * Constructeur
    */
   public Adresse() {
   }

   //Getters et Setters

   /**
    * Getter
    *
    * @return numero
    */
   public Integer getNumero() {
      return numero;
   }

   /**
    * Setter
    *
    * @param numero
    **/
   public void setNumero(Integer numero) {
      this.numero = numero;
   }

   /**
    * Getter
    *
    * @return rue
    */
   public String getRue() {
      return rue;
   }

   /**
    * Setter
    *
    * @param rue
    **/
   public void setRue(String rue) {
      this.rue = rue;
   }

   /**
    * Getter
    *
    * @return codePostal
    */
   public int getCodePostal() {
      return codePostal;
   }

   /**
    * Setter
    *
    * @param codePostal
    **/
   public void setCodePostal(int codePostal) {
      this.codePostal = codePostal;
   }

   /**
    * Getter
    *
    * @return ville
    */
   public String getVille() {
      return ville;
   }

   /**
    * Setter
    *
    * @param ville
    **/
   public void setVille(String ville) {
      this.ville = ville;
   }

}
