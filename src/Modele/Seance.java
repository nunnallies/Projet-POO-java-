/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

import DAO.JDBConnector;
import java.sql.Connection;
import java.util.*;
import java.sql.*;
import javax.swing.ImageIcon;

/**
 *
 * @author Naiss
 */
public class Seance {

    String numerosalle, heure, duree;
    String date;
    String lieu;

    public Seance Seance(String lieu, String date, String heure, String duree, String numerosalle) { // Constructeur
        this.date = date;
        this.numerosalle = numerosalle;
        this.duree = duree;
        this.lieu = lieu;
        this.heure = heure;
        return this;
    }

    public Object[][] getSeanceFilm(String IDFILM) { //Methode permettant d'obtenir toutes les séances d'un film
        Connection conn = null;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        int nb = 0;
        try {
            String requete = "SELECT count(*) from projeter WHERE IDFILM='" + IDFILM + "'";
            System.out.println(requete);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {
                nb = rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Error Occured " + e.toString());
        }
        Object donnee[][] = new Object[nb][6];
        try {
            String requete = "SELECT * from projeter WHERE IDFILM='" + IDFILM + "'";
            System.out.println(requete);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(requete);
            int i = 0;
            while (rs.next()) {
            String ID = rs.getString("NumeroSeance");
                donnee[i][0] = ID;
                i++;

            }
            for (int u = 0; u < nb; u++) {
                requete = "SELECT *  from seance WHERE NumeroSeance='" + donnee[u][0] + "'";
                st = conn.createStatement();
                rs = st.executeQuery(requete);
                System.out.println(requete);

                while (rs.next()) {
                    String Date = rs.getString("Date");
                    String Heure = rs.getString("Heure");
                    String NumeroSalle = rs.getString("NumeroSalle");
                    String DureeSeance = rs.getString("DureeSeance");
                    donnee[u][2] = NumeroSalle;
                    donnee[u][3] = Date;
                    donnee[u][4] = Heure;
                    donnee[u][5] = DureeSeance;
                    System.out.print(Arrays.deepToString(donnee));
                }
                requete = "SELECT * FROM film WHERE IDFILM='" + IDFILM + "'";
                System.out.println(requete);
                st = conn.createStatement();
                rs = st.executeQuery(requete);
                while (rs.next()) {
                    donnee[u][1] = rs.getString("Nom");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error Occured " + e.toString());
        }
        return donnee;
    }
}
