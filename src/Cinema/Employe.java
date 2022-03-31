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
import DAO.JDBConnector;
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



    public void AjouterUnFilm(String NomFilm, String Realisateur, String DateDeParution, String Synopsis, String NoteDePresse, String NoteDeSpec, String MatriculeEmploye,String Duree) {


        Connection conn = null;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        try {


            String requete = "INSERT INTO film (`Nom`,`Realisateur`,`DateDeParution`,`Synopsis`,`NoteDePresse`,`NoteDeSpectateurs`,`matriculeemploye`,`Duree`) VALUES ('"+NomFilm+"','"+Realisateur+"','"+DateDeParution +"','"+Synopsis+"','"+NoteDePresse+"','"+NoteDeSpec+"','"+MatriculeEmploye+"','"+Duree+"')";
            System.out.println(requete);

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


    }

        
    
         


    public void Reduction(int pourcentage) {

        Connection conn;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        try {
            String requete = "INSERT INTO reduction (`Pourcentage`) VALUES ('" + pourcentage + "')";
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

    }

    public void ProgrammerSeance(String NumeroSeance, String date, String heure, String DureeSeance, String numerosalle, String idfilm, String matriculeemploye) {
        Connection conn;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        try {
            String requete = "INSERT INTO seance (`NumeroSeance`,`Date`,`Heure`,`DureeSeance`,`NumeroSalle`) VALUES ('" + NumeroSeance + "','" + date + "','" + heure + "','" + DureeSeance + "','" + numerosalle + "')";
            System.out.println(requete);
            Statement st = conn.createStatement();
            int rs = st.executeUpdate(requete);

            if (rs > 0) {
                System.out.println("Le nombre de réduction ajouté à la base de donnée est de : " + rs);
            }
            if (rs == 0) {
                System.out.println("Votre requete n'a apporté aucune modification.");
            }
            requete = "INSERT INTO projeter (`NumeroSeance`,`IDFILM`,`matriculeemploye`) VALUES ('" + NumeroSeance + "','" + idfilm + "','" + matriculeemploye + "')";
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

    }

    public void SupprimerFilm(String nom) {
        Connection conn;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        try {
            String requete = "DELETE FROM film where nom='" + nom + "'";
            System.out.println(requete);
            Statement st = conn.createStatement();
            int rs = st.executeUpdate(requete);
            if (rs > 0) {
                System.out.println("Le nombre de film supprimé de la base de donnée est de : " + rs);
            }
            if (rs == 0) {
                System.out.println("Votre requete n'a apporté aucune modification.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void SupprimerReduction(int pourcentage) {
        Connection conn;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        try {
            String requete = "DELETE FROM reduction where pourcentage='" + pourcentage + "'";
            Statement st = conn.createStatement();
            System.out.println(requete);
            int rs = st.executeUpdate(requete);
            if (rs > 0) {
                System.out.println("Le nombre de réduction supprimée de la base de donnée est de : " + rs);
            }
            if (rs == 0) {
                System.out.println("Votre requete n'a apporté aucune modification.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void SupprimerSeance(int numeroseance, int numerosalle, int idfilm) {
        Connection conn;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        try {
            String requete = "DELETE FROM seance where NumeroSeance='" + numeroseance + "' AND NumeroSalle='" + numerosalle + "'";
            System.out.println(requete);
            Statement st = conn.createStatement();
            int rs = st.executeUpdate(requete);
            if (rs > 0) {
                System.out.println("Le nombre de seance supprimée de la base de donnée est de : " + rs);
            }
            if (rs == 0) {
                System.out.println("Votre requete n'a apporté aucune modification.");
            }
            requete = "DELETE FROM projeter where NumeroSeance='" + numeroseance + "' AND NumeroSalle='" + numerosalle + "' AND IDFILM='" + idfilm + "'";
            System.out.println(requete);
            st = conn.createStatement();
            rs = st.executeUpdate(requete);
            if (rs > 0) {
                System.out.println("Le nombre de seance supprimée de la base de donnée est de : " + rs);
            }
            if (rs == 0) {
                System.out.println("Votre requete n'a apporté aucune modification.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
