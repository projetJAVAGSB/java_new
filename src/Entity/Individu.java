/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.logging.Logger;

/**
 *
 * @author dadou
 */
public class Individu {
    private int codeIndividu;
    private String libelleIndividu;

    public Individu(int unCodeIndividu, String unLibelleIndividu)
    {
        codeIndividu=unCodeIndividu;
        libelleIndividu=unLibelleIndividu;
        
    }
    public Individu(String unLibelleIndividu)
    {
        libelleIndividu = unLibelleIndividu;
    }

    public Individu() {
    }
    private static Logger LOG = Logger.getLogger(Individu.class.getName());

    /**
     * @return the codeIndividu
     */
    public int getCodeIndividu() {
        return codeIndividu;
    }

    /**
     * @param codeIndividu the codeIndividu to set
     */
    public void setCodeIndividu(int codeIndividu) {
        this.codeIndividu = codeIndividu;
    }

    /**
     * @return the libelleIndividu
     */
    public String getLibelleIndividu() {
        return libelleIndividu;
    }

    /**
     * @param libelleIndividu the libelleIndividu to set
     */
    public void setLibelleIndividu(String libelleIndividu) {
        this.libelleIndividu = libelleIndividu;
    }

    /**
     * @return the LOG
     */
    public static Logger getLOG() {
        return LOG;
    }

    /**
     * @param aLOG the LOG to set
     */
    public static void setLOG(Logger aLOG) {
        LOG = aLOG;
    }
}
