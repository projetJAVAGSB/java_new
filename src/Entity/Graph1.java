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
public class Graph1 
{
    private int nbPrescription;
    private String lblMedicament;
    
    public Graph1(int unNb,String unLbl)
    {
       nbPrescription = unNb;
       lblMedicament = unLbl;
    }

    /**
     * @return the nbPrescription
     */
    public int getNbPrescription() {
        return nbPrescription;
    }

    /**
     * @return the lblMedicament
     */
    public String getLblMedicament() {
        return lblMedicament;
    }
}
