/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author fello
 */
public class Famille 
{
  private int CODE;
  private String LIBELLE;
  
  public Famille(int unCode, String unLibelle)
  {
      CODE= unCode;
      LIBELLE=unLibelle;
  }
  public Famille(String unLibelle)
  {
      
      LIBELLE=unLibelle;
  }

    /**
     * @return the CODE
     */
    public int getCODE() {
        return CODE;
    }

    /**
     * @param CODE the CODE to set
     */
    public void setCODE(int CODE) {
        this.CODE = CODE;
    }

    /**
     * @return the LIBELLE
     */
    public String getLIBELLE() {
        return LIBELLE;
    }

    /**
     * @param LIBELLE the LIBELLE to set
     */
    public void setLIBELLE(String LIBELLE) {
        this.LIBELLE = LIBELLE;
    }
}
