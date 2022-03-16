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
public class Interagir {
    private int pertubateur;
    private int pertube;
    
    public Interagir(int unPertub, int unPertube)
    {
        pertubateur = unPertub;
        pertube = unPertube;
    }
    public Interagir(int unPertube)
    {
        pertube = unPertube;
    }

    /**
     * @return the pertubateur
     */
    public int getPertubateur() {
        return pertubateur;
    }

    /**
     * @return the pertube
     */
    public int getPertube() {
        return pertube;
    }
    
}
