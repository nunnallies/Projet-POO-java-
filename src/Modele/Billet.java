/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

import DAO.JDBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;

/**
 *
 * @author Naiss
 */
public class Billet {

    String NumeroBillet, Categorie, NumeroClient, NumeroSeance, Rangee, Allee;

    public Object[][] getClientBillets(int numeroclient) {
        Connection conn;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        ArrayList<Film> films = new ArrayList<Film>();
        int nb = 0;
        try {
            PreparedStatement st = conn.prepareStatement("SELECT count(*) from billet WHERE NumeroClient='" + numeroclient + "'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                nb = rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Error Occured " + e.toString());
        }
        Object donnee[][] = new Object[nb][6];
        try {
            String requete = "SELECT * from billet WHERE NumeroClient='" + numeroclient + "'";
            System.out.println(requete);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(requete);
            int i = 0;
            while (rs.next()) {

                String ID = rs.getString("NumeroBillet");
                String cat = rs.getString("Categorie");
                String numeroseance = rs.getString("NumeroSeance");
                String rangee = rs.getString("Rangee");
                String allee = rs.getString("allee");
                System.out.println(cat + numeroseance + ID);

                donnee[i][0] = ID;
                donnee[i][1] = numeroseance;
                donnee[i][3] = cat;
                donnee[i][4] = rangee;
                donnee[i][5] = allee;
                System.out.print(Arrays.deepToString(donnee));
                i++;

            }
            for (int u = 0; u < nb; u++) {
                requete = "SELECT IDFILM from projeter WHERE NumeroSeance='" + donnee[u][1] + "'";
                st = conn.createStatement();
                rs = st.executeQuery(requete);
                System.out.println(requete);
                String transit = "";
                while (rs.next()) {
                    transit = rs.getString("IDFILM");
                }
                requete = "SELECT * FROM film WHERE IDFILM='" + transit + "'";
                System.out.println(requete);
                st = conn.createStatement();

                rs = st.executeQuery(requete);
                while (rs.next()) {
                    donnee[u][2] = rs.getString("Nom");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error Occured " + e.toString());

        }
        System.out.println(Arrays.deepToString(donnee));
        return donnee;
    }
}
