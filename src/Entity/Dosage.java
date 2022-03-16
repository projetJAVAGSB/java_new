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
public class Dosage {

 private int code;
 private String forme;
 private int quantite;
 private String unite;
 
 public Dosage(int unCode, String uneForme, int UneQt, String uneUnite)
 {
     code = unCode;
     forme = uneForme;
     quantite = UneQt;
     unite = uneUnite;
     
 }
 public Dosage(String uneForme)
 {
     forme = uneForme;
 }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @return the forme
     */
    public String getForme() {
        return forme;
    }

    /**
     * @return the quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * @return the unite
     */
    public String getUnite() {
        return unite;
    }
                  
    
}
