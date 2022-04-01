/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.ImageIcon;
import DAO.JDBConnector;
import javax.swing.text.html.HTML;

/**
 *
 * @author Naiss
 */
public class Client {

    String nom, prenom, adresse, mail;
    int numeroclient, age;

<<<<<<< HEAD:src/Cinema/Client.java
    public Client Client(int numeroclient, String nom, String prenom, int age, String adresse, String mail) {
        this.adresse = adresse;
        this.age = age;
        this.mail = mail;
        this.prenom = prenom;
        this.nom = nom;
        this.numeroclient = numeroclient;
        return this;
    }

   
=======
    
>>>>>>> 267142f6c2825afcb226427a64a266795bf1037a:src/Modele/Client.java

    public boolean VerifierExistenceCompte(String pseudonyme, String mdp) {
        Connection conn;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        int a = -1;
        try {
            PreparedStatement st = conn.prepareStatement("SELECT count(*) from compte WHERE Pseudonyme='" + pseudonyme + "' AND MotDePasse='" + mdp + "'");
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

    public void AcheterUnBillet(String Categorie, String numeroseance, int numeroclient,char rangee, int allee) {
        Connection conn = null;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        char A;
        try {
<<<<<<< HEAD:src/Cinema/Client.java
            String requete = "INSERT INTO billet (`Categorie`,`numeroseance`,`numeroclient`,`rangee`,`alle`) VALUES ('" + Categorie + "','" + numeroseance + "','" + numeroclient + "','" + rangee + "','" + allee + "')";
=======
            String requete = "INSERT INTO billet (`Categorie`,`numeroseance`,`numeroclient`,`rangee`,`allee`) VALUES ('" + Categorie + "','" + numeroseance + "','" + numeroclient + "','" + rangee + "','" + allee + "')";
>>>>>>> 267142f6c2825afcb226427a64a266795bf1037a:src/Modele/Client.java
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
            String requete = "INSERT INTO facture (`prix`, `lieu`, `Date`, `IDREDUCTION`,`numeroclient`,`numerobillet`) VALUES ('" + prix + "','" + lieu + "','" + Date + "','" + IDreduction + "','" + numeroclient + "','" + numerobillet + "')";
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

    public Object[][] getClients(){
        Connection conn;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        ArrayList<Film> films= new ArrayList<Film>();
        int nb=0;
        try {
            PreparedStatement st = conn.prepareStatement("SELECT count(*) from client");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                nb= rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Error Occured " + e.toString());
        }
        Object donnee[][]=new Object[nb][6];
         try {
            String requete = "SELECT * from client";
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
                donnee[i][0]=ID;
                donnee[i][1]=nom;
                donnee[i][2]=prenom;
                donnee[i][3]=Age;
                donnee[i][4]=Adresse;
                donnee[i][5]=Mail;
                System.out.print(Arrays.deepToString(donnee));
                i++;



            } }catch (SQLException e){
                    e.printStackTrace();
                    }
            return donnee; 
    }
        
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
        Object donnee[][] = new Object[nb][5];
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
           for(int u=0;u<nb;u++){
           requete="SELECT ID from projeter WHERE NumeroSeance='"+donnee[u][1]+"'";
           st = conn.createStatement();
           rs=st.executeQuery(requete);
           String transit=rs.getString("IDFILM");
           requete="SELECT FROM film WHERE IDFILM='"+transit+"'";
           st=conn.createStatement();
           rs=st.executeQuery(requete);
           donnee[u][2]=rs.getString("Nom");
           } } catch (SQLException e) {
            System.out.println("Error Occured " + e.toString());

        }
        System.out.println(Arrays.deepToString(donnee));
        return donnee;
    }
   public Object[][] getfilms() {
        Connection conn;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        ArrayList<Film> films= new ArrayList<Film>();
        int nb=0;
        try {
<<<<<<< HEAD:src/Cinema/Client.java
            PreparedStatement st = conn.prepareStatement("SELECT count(*) from client");
=======
            PreparedStatement st = conn.prepareStatement("SELECT count(*) from film");
>>>>>>> 267142f6c2825afcb226427a64a266795bf1037a:src/Modele/Client.java
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                nb= rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Error Occured " + e.toString());
        }
        Object donnee[][]=new Object[nb][11];
        try {
            String requete = "SELECT * from film";
            System.out.println(requete);
            Statement st = conn.createStatement();
            ResultSet rs=st.executeQuery(requete);
            int i=0;
            while (rs.next()){
               
                String ID=rs.getString("IDFILM");
                String nom=rs.getString("Nom");
                String realisateur=rs.getString("Realisateur");
                String DateDeParution=rs.getString("DateDeParution");
                String NoteDePresse=rs.getString("NoteDePresse");
                String NoteDeSpec=rs.getString("NoteDeSpectateurs");
                String Synopsis=rs.getString("Synopsis");
                String MatriculeEmploye=rs.getString("MatriculeEmploye");
                String Duree=rs.getString("Duree");
                String url=rs.getString("path");
                System.out.println(DateDeParution+Synopsis+MatriculeEmploye+ID);

                donnee[i][0]=new ImageIcon(url);

                ImageIcon image = new ImageIcon(url);
                donnee[i][0]=image;

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
                
                
                
            }
            

        } catch (SQLException e){
             System.out.println("Error Occured " + e.toString());
            
        }
        System.out.println(Arrays.deepToString(donnee));
        return donnee;
    }
    
}
    
    