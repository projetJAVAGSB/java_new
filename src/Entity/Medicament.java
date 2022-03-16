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
public class Medicament 
{

    /**
     * @return the famille
     */
    public String getFamille() {
        return famille;
    }
     private int depotLegal;
    private String nomCommercial;
    private String famille;
    private float prixEchantillion;
    private String composition;
    private String effets;
    private String contreIndication;
    
    private int code;
    
    
    
    
    public Medicament(int unDepot, String unNom,String uneFamille,float unPrix, String uneCompo,String unEffet,String unContreIndi)
    {
       depotLegal=unDepot;
       nomCommercial=unNom;
       famille= uneFamille;
       prixEchantillion=unPrix;
       composition=uneCompo;
       effets= unEffet;
       contreIndication=unContreIndi;
      
      
    }
      public Medicament(String unNom,String uneFamille,float unPrix, String uneCompo,String unEffet,String unContreIndi)
    {
       
       nomCommercial=unNom;
       famille= uneFamille;
       prixEchantillion=unPrix;
       composition=uneCompo;
       effets= unEffet;
       contreIndication=unContreIndi;
      
      
    }
    public Medicament(int unDepot, String unNom)
    {
       depotLegal=unDepot;
       nomCommercial=unNom;
       
    }
    
      public Medicament( String unNom)
    {
       
       nomCommercial=unNom;
       
    }
    public Medicament( int unDepot)
    {
       
       depotLegal=unDepot;
       
    }

    /**
     * @return the depotLegal
     */
    public int getDepotLegal() {
        return depotLegal;
    }

    /**
     * @param depotLegal the depotLegal to set
     */
    public void setDepotLegal(int depotLegal) {
        this.depotLegal = depotLegal;
    }

    /**
     * @return the nomCommercial
     */
    public String getNomCommercial() {
        return nomCommercial;
    }

    /**
     * @param nomCommercial the nomCommercial to set
     */
    public void setNomCommercial(String nomCommercial) {
        this.nomCommercial = nomCommercial;
    }

    /**
     * @return the composition
     */
    public String getComposition() {
        return composition;
    }

    /**
     * @param composition the composition to set
     */
    public void setComposition(String composition) {
        this.composition = composition;
    }

    /**
     * @return the effets
     */
    public String getEffets() {
        return effets;
    }

    /**
     * @param effets the effets to set
     */
    public void setEffets(String effets) {
        this.effets = effets;
    }

    /**
     * @return the contreIndication
     */
    public String getContreIndication() {
        return contreIndication;
    }

    /**
     * @param contreIndication the contreIndication to set
     */
    public void setContreIndication(String contreIndication) {
        this.contreIndication = contreIndication;
    }

    /**
     * @return the prixEchantillion
     */
    public float getPrixEchantillion() {
        return prixEchantillion;
    }

    /**
     * @param prixEchantillion the prixEchantillion to set
     */
    public void setPrixEchantillion(float prixEchantillion) {
        this.prixEchantillion = prixEchantillion;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }
}
