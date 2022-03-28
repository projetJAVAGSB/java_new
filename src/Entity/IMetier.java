/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author fello
 */
    public interface IMetier {
        
        //fonction connexion et inscrit+ption : 
        public User GetUnUser(String login, String mdp);
        public void InsertUser(String pseudoUser, String mdpUser);
        public boolean GetAllUser(String pseudoUser);
        
        
        
        
        //fonction medicaments : 
    public ArrayList<Medicament> getAllMedicaments();
    public ArrayList<Medicament> getAllInfosMedicaments(int numMedoc);
    public void InsererUnMedicament(String uneCompo,String unNom,float unPrix,String unEffet,String uneFamille,String unContreIndi);
    public void ajouterMedicament(Medicament unMedicament);
    //public void InsererUnMedicament(String unNom,String uneCompo,String unEffet, String unContreIndi,  float unPrix,  String uneFamille);
    public void modifierMedoc(int unDepo, String unNom, String uneCompo,float unPrix, String unEffet,  String unContreIndi);
    public Medicament getLeMedicament(int code);
    
    
    //fonction Individus :
    public void modifierIndividu(String unLabelle, int unCode);
    public ArrayList<Individu> GetAllIndividus();
    //public ArrayList<Individu> GetAllIndividusGraph();
    public void InsererIndividu(String libelle);
    public ArrayList<Individu>GetNomIndividus();
    
    
    //fonction nom des familles :
    public ArrayList<Famille> getAllNomFamille();
    
    
    //fonction afficher dosage : 
 public ArrayList<Dosage> getAllDosage();
 
 //focntion inserer une prescription : 
public void InsererUnePrescription( String TIN_LIBELLE,String forme,String nomCommercial,  String posologie) ;

//fonction interaction :
public void InsererInteraction(int numMedoc,int numMedocperturber);
    
    
 //fonction perturbateur :    
 public ArrayList<Interagir>GetAllPerturbateur();
   
 
 //Graphique
 public ArrayList<Graph1> GetGraph1(String lblIndiv);
    
}


