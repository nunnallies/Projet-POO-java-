/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cinema;

import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import projetjava.utils.JDBConnector;
import java.sql.*;

/**
 *
 * @author Naiss
 */
public class Employe {

    String nom, prenom, login, motdepasse;
    Date debutcontrat;

    public boolean VerifierExistenceEmploye(String pseudonyme, String mdp) {
        Connection conn;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        int a = -1;
        try {
            PreparedStatement st = conn.prepareStatement("SELECT count(*) from employe WHERE login='" + pseudonyme + "' AND motdepasse='" + mdp + "'");
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

    public Film AjouterUnFilm(int MatriculeEmploye, String NomFilm, String Realisateur, Date DateDeParution, String Synopsis, float NoteDePresse, float NoteDeSpec) {
        Connection conn = null;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        try {
            String requete = "INSERT INTO film ('Nom', 'Realisateur', 'DateDeParution', 'Synopsis', 'NoteDePresse', 'NoteDeSpectateurs', 'NombreSpec', 'matriculeemploye') VALUES ('" + NomFilm + "','" + Realisateur + "','" + DateDeParution + "','" + Synopsis + "','" + NoteDePresse + "','" + NoteDeSpec + "')";
            Statement st = conn.createStatement();
            int rs = st.executeUpdate(requete);
            if (rs > 0) {
                System.out.println("Le nombre de film ajouté à la base de donnée est de : " + rs);
            }
            if (rs == 0) {
                System.out.println("Votre requete n'a apporté aucune modification.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Film nouveaufilm = new Film(NomFilm, Realisateur, DateDeParution, NoteDePresse, NoteDeSpec, Synopsis, MatriculeEmploye);
        return nouveaufilm;

    }

    public Reduction AjouterUneReduction(int pourcentage) {

        Connection conn;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        try {
            String requete = "INSERT INTO reduction ('Pourcentage') VALUES ('" + pourcentage + "')";
            Statement st = conn.createStatement();
            int rs = st.executeUpdate(requete);

            if (rs > 0) {
                System.out.println("Le nombre de réduction ajouté à la base de donnée est de : " + rs);
            }
            if (rs == 0) {
                System.out.println("Votre requete n'a apporté aucune modification.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Reduction nouvellereduc = new Reduction(pourcentage);
        return nouvellereduc;
    }

    public Seance ProgrammerSeance(int numeroseance, String Lieu, Date date, int heure, int duree, int numerosalle, int matriculeemploye, int idfilm) {
        Connection conn;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        try {
            String requete = "INSERT INTO seance ('Lieu','Date','Heure','NumeroSalle') VALUES ('" + Lieu + "','" + date + "','" + heure + "','" + numerosalle + "')";
            Statement st = conn.createStatement();
            int rs = st.executeUpdate(requete);

            if (rs > 0) {
                System.out.println("Le nombre de réduction ajouté à la base de donnée est de : " + rs);
            }
            if (rs == 0) {
                System.out.println("Votre requete n'a apporté aucune modification.");
            }
            requete = "INSERT INTO projeter ('NumeroSeance','IDFILM','matriculeemploye') VALUES ('" + numeroseance + "','" + idfilm + "','" + matriculeemploye + "')";
            st = conn.createStatement();
            rs = st.executeUpdate(requete);

            if (rs > 0) {
                System.out.println("Le nombre de réduction ajouté à la base de donnée est de : " + rs);
            }
            if (rs == 0) {
                System.out.println("Votre requete n'a apporté aucune modification.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Seance nouvelleseance=new Seance(Lieu,date,heure,duree,numerosalle);
        return nouvelleseance;

    }
    
    public void SupprimerFilm(String nom){
        Connection conn;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        
    }
    

}
