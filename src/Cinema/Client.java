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
import java.sql.Statement;
import java.util.*;
import javax.swing.ImageIcon;
import projetjava.utils.JDBConnector;

/**
 *
 * @author Naiss
 */
public class Client {

    String nom, prenom, adresse, mail;
    int numeroclient, age;

    Client(int numeroclient, String nom, String prenom, int age, String adresse, String mail) {
        this.adresse = adresse;
        this.age = age;
        this.mail = mail;
        this.prenom = prenom;
        this.nom = nom;
        this.numeroclient = numeroclient;
    }

    public boolean VerifierExistenceCompte(String pseudonyme, String mdp) {
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

    public Compte CreerUnCompte(int numeroclient, String mail, String pseudonyme, String motdepasse) {
        Connection conn = null;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        try {
            String requete = "INSERT INTO film (`NumeroClient`, `Mail`, `Pseudonyme`, `MotDePasse`) VALUES ('" + numeroclient + "','" + mail + "','" + pseudonyme + "','" + motdepasse + "')";
            Statement st = conn.createStatement();
            System.out.println(requete);
            int rs = st.executeUpdate(requete);
            if (rs > 0) {
                System.out.println("Le nombre de compte  ajouté à la base de donnée est de : " + rs);
            }
            if (rs == 0) {
                System.out.println("Votre requete n'a apporté aucune modification.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Compte compte = new Compte(numeroclient, mail, pseudonyme, motdepasse);
        return compte;
    }

    public void AcheterUnBillet(int nbclient, String Categorie, int prix, int numeroseance, int numeroclient, char rangee, int allee) {
        Connection conn = null;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        try {
            String requete = "INSERT INTO film (`nbclient`, `Categorie`, `prix`, `numeroseance`,`numeroclient`,`rangee`,`alle`) VALUES ('" + nbclient + "','" + Categorie + "','" + prix + "','" + numeroseance + "','" + numeroclient + "','" + rangee + "','" + allee + "')";
            Statement st = conn.createStatement();
            System.out.println(requete);
            int rs = st.executeUpdate(requete);
            if (rs > 0) {
                System.out.println("Le nombre de compte  ajouté à la base de donnée est de : " + rs);
            }
            if (rs == 0) {
                System.out.println("Votre requete n'a apporté aucune modification.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void PayerFacture(int prix, String lieu, String Date, int IDreduction, int numeroclient, int numerobillet) {
        Connection conn = null;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        try {
            String requete = "INSERT INTO film (`prix`, `lieu`, `Date`, `IDREDUCTION`,`numeroclient`,`numerobillet`) VALUES ('" + prix + "','" + lieu + "','" + Date + "','" + IDreduction + "','" + numeroclient + "','" + numerobillet + "')";
            Statement st = conn.createStatement();
            System.out.println(requete);
            int rs = st.executeUpdate(requete);
            if (rs > 0) {
                System.out.println("Le nombre de compte  ajouté à la base de donnée est de : " + rs);
            }
            if (rs == 0) {
                System.out.println("Votre requete n'a apporté aucune modification.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void SupprimerReservation(int numerobillet, int numeroclient) {
        Connection conn;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        try {
            String requete = "DELETE FROM facture where NumeroBillet='" + numerobillet + "' AND NumeroClient='" + numeroclient + "'";
            System.out.println(requete);
            Statement st = conn.createStatement();
            int rs = st.executeUpdate(requete);
            if (rs > 0) {
                System.out.println("Le nombre de facture supprimé de la base de donnée est de : " + rs);
            }
            if (rs == 0) {
                System.out.println("Votre requete n'a apporté aucune modification.");
            }
            requete = "DELETE FROM billet where NumeroBillet='" + numerobillet + "'AND NumeroClient='" + numeroclient + "'";
            System.out.println(requete);
            st = conn.createStatement();
            rs = st.executeUpdate(requete);
            if (rs > 0) {
                System.out.println("Le nombre de billet supprimé de la base de donnée est de : " + rs);
            }
            if (rs == 0) {
                System.out.println("Votre requete n'a apporté aucune modification.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public String VoirBillets(int numeroclient) {
        Connection conn;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        int a = 0; //sert à dimensionner la taille de la JTable
        try {
            PreparedStatement st = conn.prepareStatement("SELECT count(*) from billet WHERE NumeroClient='" + numeroclient + "'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                a = rs.getInt(numeroclient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String donnes[][]=new String[a][8];
        try{
            String requete="SELECT * from billet WHERE NumeroClient="+numeroclient+"'";
            System.out.println(requete);
            Statement st=conn.createStatement();
            
            
            
            
        }
        
        

    }*/
    
    public Object[][] getClients(){
        Connection conn;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        ArrayList<Film> films= new ArrayList<Film>();
        int nb=0;
        try {
            PreparedStatement st = conn.prepareStatement("SELECT count(*) from clients");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                nb= rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Error Occured " + e.toString());
        }
        Object donnee[][]=new Object[nb][11];
         try {
            String requete = "SELECT * from Client";
            System.out.println(requete);
            Statement st = conn.createStatement();
            ResultSet rs=st.executeQuery(requete);
            int i=0;
            while (rs.next()){
               
                String ID=rs.getString("NumeroClient");
                String nom=rs.getString("Nom");
                String prenom=rs.getString("Prenom");
                String Age=rs.getString("Age");
                String Adresse=rs.getString("Adresse");
                String Mail=rs.getString("Mail");
                System.out.println(ID+nom+Mail+ID);
                donnee[i][0]=new ImageIcon(""+url+"");
                donnee[i][1]=nom;
                donnee[i][2]=realisateur;
                donnee[i][3]=Duree;
                donnee[i][4]=Synopsis;
                donnee[i][5]=DateDeParution;
                donnee[i][6]=NoteDePresse;
                donnee[i][7]=NoteDeSpec;
                donnee[i][8]=MatriculeEmploye;
                donnee[i][9]=ID;
                System.out.print(Arrays.deepToString(donnee));
                i++;
                
                
                
            } }catch (SQLException e){
                    e.printStackTrace();
                    }
            
    }
     

}
