/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;
import java.sql.Connection;
import Entity.User;
import Entity.Dosage;
import Entity.Prescrire;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fello
 */
public class FonctionMetier implements IMetier

{

    public ArrayList<Medicament> getInteraction() {
        ArrayList<Medicament> lesMedicaments = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select DEPOTLEGAL, NOMCOMMERCIAL from medicament");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                
                Medicament m = new Medicament(rs.getInt("DEPOTLEGAL"), rs.getString("NOMCOMMERCIAL"));
                lesMedicaments.add(m);
            }
            ps.close();
        
        }   catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMedicaments;
        
    }
        public ArrayList<Medicament> getAllMedicaments() {
        ArrayList<Medicament> lesMedicaments = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select m.depotlegal, m.nomcommercial , m.prixechantillon,m.composition,m.effets,m.contreindic from medicament m;");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                
                Medicament m = new Medicament(rs.getInt("m.depotlegal"),rs.getString("m.nomcommercial"), rs.getInt("m.prixechantillon"), rs.getString("m.composition"),rs.getString("m.contreindic"));
                lesMedicaments.add(m);
            }
            ps.close();
        
        }   catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMedicaments;
        
    }
    @Override
    public void ajouterMedicament(Medicament unMedicament) 
    
    {
//        Connection cnx = ConnexionBDD.getCnx();
//            PreparedStatement ps = cnx.prepareStatement("insert into jeux values (?,?,?,?)");
//            ps.setInt(1, unJeu.getIdJeu());
//            ps.setString(2, unJeu.getNomJeu());
//            ps.setString(3, unJeu.getImageJeu());
//            ps.setInt(4, unJeu.getLaCategorie().getIdCategorie());
//            ps.executeUpdate();
//            ps.close();
    }

    @Override
    public ArrayList<Medicament> getAllInfosMedicaments(int numMedoc) {
         ArrayList<Medicament> lesInfosMedicaments = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select m.nomcommercial , f.libelle , m.prixechantillon,m.composition,m.effets,m.contreindic from medicament m inner join famille f on m.DEPOTLEGAL = f.CODE where m.DEPOTLEGAL=" +numMedoc);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                
            {
//                rs.getInt("DEPOTLEGAL"), rs.getString("NOMCOMMERCIAL")
                
                Medicament infoM = new Medicament(rs.getString("m.nomcommercial"),rs.getString("f.libelle"),rs.getFloat("prixechantillon"),rs.getString("m.composition"),rs.getString("m.effets"),rs.getString("m.contreindic"));
                lesInfosMedicaments.add(infoM);
            }
            ps.close();
        
        }   catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesInfosMedicaments;
    }

    @Override
    public ArrayList<Famille> getAllNomFamille() {
        ArrayList<Famille> lesFamilles = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select LIBELLE from famille");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                
                Famille f= new Famille( rs.getString("LIBELLE"));
                lesFamilles.add(f);
            }
            ps.close();
        
        }   catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesFamilles;
    }
    
    //connexion user :
    public User GetUnUser(String pseudoUser, String mdpUser)
    {
        User unUser = null;
        try
        {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select id, pseudo, mdp from utilisateur  where pseudo = '"+pseudoUser+"' and mdp = '"+mdpUser+"'");
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                unUser = new User( rs.getString("pseudo"), rs.getString("mdp"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unUser;
    }



   
     public ArrayList<Medicament> getAllNomMedicaments() {
        ArrayList<Medicament> lesMedicaments = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select NOMCOMMERCIAL from medicament");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                
                Medicament m = new Medicament( rs.getString("NOMCOMMERCIAL"));
                lesMedicaments.add(m);
            }
            ps.close();
        
        }   catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMedicaments;
        
    }
      public ArrayList<Medicament> getAllMedicamentsPerturber(int code) {
        ArrayList<Medicament> lesMedicamentsPerturber = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            
            
            
            
            PreparedStatement ps = cnx.prepareStatement("select m.DEPOTLEGAL , m.NOMCOMMERCIAL from medicament m inner join interagir i on m.DEPOTLEGAL=i.PERTURBATEUR where i.perturber = "+code);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                
                Medicament m = new Medicament(rs.getInt("DEPOTLEGAL"), rs.getString("NOMCOMMERCIAL"));
                lesMedicamentsPerturber.add(m);
            }
            ps.close();
        
        }   catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMedicamentsPerturber;
        
    }
    public ArrayList<Medicament> getAllMedicamentsNonPerturber(int code) {
        ArrayList<Medicament> lesMedicamentsPerturber = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select m.DEPOTLEGAL , m.NOMCOMMERCIAL from medicament m  Where DEPOTLEGAL not in( select m.DEPOTLEGAL  from medicament m inner join interagir i on m.DEPOTLEGAL=i.PERTURBATEUR where i.perturber = "+code+")AND DEPOTLEGAL !="+code+"");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                
                Medicament m = new Medicament(rs.getInt("DEPOTLEGAL"), rs.getString("NOMCOMMERCIAL"));
                lesMedicamentsPerturber.add(m);
            }
            ps.close();
        
        }   catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMedicamentsPerturber;
        
    }
     
     
     
        public ArrayList<Dosage> getAllDosage() {
        ArrayList<Dosage> lesDosages = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select forme from dosage");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                
                Dosage d = new Dosage(rs.getString("forme"));
                lesDosages.add(d);
            }
            ps.close();
        
        }   catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesDosages;
        
    }


    @Override
        //public void InsererUnePrescription(String nomCommercial, String libelle, String forme, String posologie) 

    public void InsererUnePrescription(String nomCommercial, String TIN_LIBELLE,String forme,  String posologie) 
    {
        try
     {
        Connection cnx = ConnexionBDD.getCnx();
        
        //SELECT medicament.DEPOTLEGAL from medicament WHERE medicament.NOMCOMMERCIAL = 'maalox'
        
        PreparedStatement ps = cnx.prepareStatement("SELECT medicament.DEPOTLEGAL from medicament WHERE medicament.NOMCOMMERCIAL = '"+nomCommercial+"'");
        ResultSet rs = ps.executeQuery();
        rs.next();
        int numCodeMedoc = rs.getInt(1);
        
        
        
         ps = cnx.prepareStatement("SELECT TIN_CODE from type_individu WHERE TIN_LIBELLE = '"+TIN_LIBELLE+"'");
         rs = ps.executeQuery();
        rs.next();
        int numTypeeIndividu = rs.getInt(1);
        
         ps = cnx.prepareStatement("SELECT CODE FROM dosage WHERE FORME = '"+forme+"'");
         rs = ps.executeQuery();
        rs.next();
        int numDose = rs.getInt(1);
        //ps = cnx.prepareStatement("insert into prescrire("+numTypeeIndividu+",'"+numDose+"','"+numCodeMedoc+"','"+posologie);
        ps = cnx.prepareStatement("insert into prescrire values ("+numCodeMedoc+","+numTypeeIndividu+","+numDose+",'"+posologie+"')");
        
//        select m.NOMCOMMERCIAL, t.tin_libelle, d.forme, p.possologie from medicament m inner join prescrire p on m.DEPOTLEGAL = p.CODE inner JOIN type_individu t on p.CODE = t.TIN_CODE INNER JOIN dosage d on p.CODE = d.CODE'"
        ps.executeUpdate();
        ps.close();
     }  catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }    

    
    
    public ArrayList<Individu> GetAllIndividus() {
        ArrayList<Individu> lesIndividus = new ArrayList<>();
        try {
             Connection c = ConnexionBDD.getCnx();
            PreparedStatement s = c.prepareStatement("select TIN_CODE, TIN_LIBELLE from type_individu");
            System.out.println(s);
            ResultSet rs = s.executeQuery();
            while(rs.next())
            {
               lesIndividus.add(new Individu(rs.getInt("TIN_CODE"), rs.getString("TIN_LIBELLE"))); 

            }
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesIndividus;    }

    @Override
    public ArrayList<Individu> GetNomIndividus() {
        ArrayList<Individu> lesIndividus = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select  TIN_LIBELLE from type_individu");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                
                Individu i = new Individu();
                lesIndividus.add(i);
            }
            ps.close();
        
        }   catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesIndividus;    }
    
    //inscription user 
    public void InsertUser(String pseudoUser,String mdpUser) {
 try
     {
        Connection cnx = ConnexionBDD.getCnx();
        PreparedStatement ps = cnx.prepareStatement("select id, pseudo, mdp from utilisateur where pseudo = '"+pseudoUser);
         ps = cnx.prepareStatement("insert into utilisateur values (null,'"+pseudoUser+"','"+mdpUser+"')");
        ps.executeUpdate();
        
     }  catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Interagir> GetAllPerturbateur() {
        ArrayList<Interagir> lesInteragir= new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select  perturbarteur from interagir");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                
                Interagir in = new Interagir(rs.getInt("perturbarteur"));
                lesInteragir.add(in);
            }
            ps.close();
        
        }   catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesInteragir;    }



    @Override
    public void modifierIndividu(String unLabelle, int unCode) {
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("update type_individu set TIN_LIBELLE = '"+unLabelle + "' where TIN_CODE = "+unCode+"");
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    @Override
    public void InsererIndividu(String libelle) {
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("insert into type_individu values(null,'"+libelle+"')");
            ps.executeUpdate();
        } catch (SQLException ex) {
            
        }
    
        
    }

    @Override
    public void InsererInteraction(int numMedoc, int numMedocperturber) {
        try
     {
        Connection cnx = ConnexionBDD.getCnx();
        PreparedStatement ps = cnx.prepareStatement("insert into interagir values ("+numMedoc+","+numMedocperturber+")");
        ps.executeUpdate();
        
     }  catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    
    
    
    //FONCTION MEDICAMENT :
    
        @Override
    public void InsererUnMedicament(String uneCompo, String unNom, float unPrix, String unEffet, String uneFamille, String unContreIndi) {

 try
     {
        Connection cnx = ConnexionBDD.getCnx();
        
        
        
        PreparedStatement ps = cnx.prepareStatement("SELECT famille.CODE from famille WHERE famille.LIBELLE = '"+uneFamille+"'");
        ResultSet rs = ps.executeQuery();
        rs.next();
        int numCodeFamille = rs.getInt(1);
        ps.close();
         ps = cnx.prepareStatement("insert into medicament  values (null,'"+unNom+"','"+uneCompo+"','"+unEffet+"','"+unContreIndi+"',"+unPrix+","+numCodeFamille +")");
        ps.executeUpdate();
        ps.close();
        
     }  catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
//    @Override
//    public void InsererUnMedicament(String unNom,String uneCompo,String unEffet, String unContreIndi,  float unPrix,  String uneFamille) 
//    {
//        
//      try
//     {
//        Connection cnx = ConnexionBDD.getCnx();
////        PreparedStatement ps = cnx.prepareStatement("insert into medicament  values ('"+uneCompo+"','"+unNom+"',"+unPrix+",'"+unEffet+"','"+uneFamille+"','"+unContreIndi+"')");
//PreparedStatement ps = cnx.prepareStatement("insert into medicament  values ('"+unNom+"','"+uneCompo+"',"+unEffet+",'"+unContreIndi+"','"+unPrix+"','"+uneFamille+"')");
//        ps.executeUpdate();
//
//     }  catch (SQLException ex) {
//            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
//        }      
//        
//        
//    }
    
    @Override
    public Medicament getLeMedicament(int code) {
        Medicament m = null;
       try
     {
        Connection cnx = ConnexionBDD.getCnx();
        PreparedStatement ps = cnx.prepareStatement("select DEPOTLEGAL,NOMCOMMERCIAL,COMPOSITION,EFFETS,CONTREINDIC,PRIXECHANTILLON,CODE from medicament where depotlegal = "+code);
        ResultSet rs = ps.executeQuery();
        rs.next() ;
        
         //m = new Medicament(rs.getInt("DEPOTLEGAL"), rs.getString("NOMCOMMERCIAL"), rs.getString("COMPOSITION"), rs.getString("EFFETS"), rs.getString("CONTREINDIC"), rs.getFloat("PRIXECHANTILLON"), rs.getInt("CODE"));
         m = new Medicament(rs.getInt("DEPOTLEGAL"), rs.getString("NOMCOMMERCIAL"), rs.getString("COMPOSITION"), rs.getInt("CODE"), rs.getString("COMPOSITION"), rs.getString("EFFETS"), rs.getString("CONTREINDIC"));

     
     }  catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }

    @Override
    public void modifierMedoc(String uneDepo, String unNom, float unPrix, String unEffet, String uneFamille, String unContreIndi) 
    {
        try 
        {
             Connection c = ConnexionBDD.getCnx();
            PreparedStatement s = c.prepareStatement("update medicament set DEPOTLEGAL="+uneDepo+" NOMCOMMERCIAL='"+ unNom +"',PRIXECHANTILLON ="+unPrix+" EFFETS='"+ unEffet +"' where DEPOTLEGAL="+uneDepo);
            s.execute();
            System.out.println(s);                  
        } 
        catch(SQLException exception) 
        {
            Logger.getLogger(ConnexionBDD.class.getName()).log(Level.SEVERE, null, exception);   
        }
    }

    public ArrayList<String> GetAllIndividusGraph() {
         ArrayList<String> lesNomsDesIndives = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select  TIN_LIBELLE from type_individu");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                lesNomsDesIndives.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesNomsDesIndives;
    }
    
    
public HashMap<String,Double> GetDatasGraphique1(String lblIndiv)
    {
        // Une HashMap est une collection dans laquelle
        // on stocke une clé et une valeur
        // Dans cet exemple, la clé est une chaîne de caractères
        // qui correspond au nom du trader
        // La valeur est un double qui correspond au prix d'achat.
        
        // Dans ce type de collection la clé est UNIQUE : donc
        // pas de doublons possibles.
        // On considère ici que 2 traders n'auront pas le même nom :)
        HashMap<String, Double> datas = new HashMap();
        try {
             Connection cnx = ConnexionBDD.getCnx();
             PreparedStatement ps = cnx.prepareStatement("select prescrire.DEPOTLEGAL, COUNT(prescrire.CODE) as compteur\n" +
                                    "from prescrire\n" +
                                    "LEFT join medicament   ON prescrire.DEPOTLEGAL= medicament.DEPOTLEGAL\n" +
                                    "LEFT join type_individu ON  prescrire.CODE= type_individu.TIN_CODE\n" +
                                    "WHERE type_individu.TIN_LIBELLE ='"+lblIndiv+"'");
             ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                datas.put(rs.getString(1), rs.getDouble(2));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return datas;
    }
  



   


   

   
}

//try
//     {
//        Connection cnx = ConnexionBDD.getCnx();
//        PreparedStatement ps = cnx.prepareStatement("insert into medicament  values ('"+uneCompo+"','"+unNom+"',"+unPrix+",'"+unEffet+"','"+uneFamille+"','"+unContreIndi+"')");
//        ps.executeUpdate();
//        
//     }  catch (SQLException ex) {
//            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
//        }    }
        
    

  

  

    

  


    

