/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cinema;

import static java.awt.image.ImageObserver.WIDTH;
import java.sql.*;
import DAO.JDBConnector;

/**
 *
 * @author Naiss
 */
public class Compte {

    int numerocompte, numeroclient;
    String MotDePasse, pseudonyme;
    String mail;

    Compte(int numeroclient, String mail, String pseudonyme, String MotDePasse) {

        this.pseudonyme = pseudonyme;

        this.mail = mail;
        this.MotDePasse = MotDePasse;
        this.numeroclient = numeroclient;
        this.numerocompte = numerocompte;

    }
    
    public boolean VerifierExistenceCompte(String pseudonyme,String mdp){
        Connection conn;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        int a = -1;
        try {
            PreparedStatement st = conn.prepareStatement("SELECT count(*) from compte WHERE pseudonyme='" + pseudonyme + "' AND motdepasse='" + mdp + "'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                a = rs.getInt(WIDTH);
            }

        } catch (SQLException e) {
            System.out.println("Error Occured " + e.toString());
        }
        System.out.println("Le nombre d'element répondant aux criteres est de :" + a);
        if (a == 0) {
            return false;
        } else {
            return true;
        }
    }

}
