/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fello
 */
public class ConnexionBDD 
{
    private static Connection cnx;
        // Mon objet connexion
    public ConnexionBDD()
    {
        try
        {
            String pilote = "com.mysql.jdbc.Driver";
            // chargement du pilote
            Class.forName(pilote);
            // L'objet connexion à la BDD avec le nom de la base, le user et le password
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/projetmedicament?serverTimezone="
                    + TimeZone.getDefault().getID(), "root", "");
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(ConnexionBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Connection getCnx() {
        return cnx;
    }
}
