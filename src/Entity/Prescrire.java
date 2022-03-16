/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author orel
 */
public class Prescrire {
    private int idPres;
    private int codeDos;
    private int depotLegal;
    private String posologie;
    
    public Prescrire(int unId, int unCode, int unDepot, String unPosologie)
    {
        unId = idPres;
        unCode = codeDos;
        unDepot = depotLegal;
        unPosologie = posologie;
    }
    
    public Prescrire(String unPosologie)
    {
        unPosologie = posologie;
    }
    
    

    /**
     * @return the idPres
     */
    public int getIdPres() {
        return idPres;
    }

    /**
     * @return the codeDos
     */
    public int getCodeDos() {
        return codeDos;
    }

    /**
     * @return the depotLegal
     */
    public int getDepotLegal() {
        return depotLegal;
    }

    /**
     * @return the posologie
     */
    public String getPosologie() {
        return posologie;
    }

    /**
     * @param posologie the posologie to set
     */
    public void setPosologie(String posologie) {
        this.posologie = posologie;
    }
    
    
    
}
