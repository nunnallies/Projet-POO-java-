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


    public Client Client(int numeroclient, String nom, String prenom, int age, String adresse, String mail) {
        this.adresse = adresse;
        this.age = age;
        this.mail = mail;
        this.prenom = prenom;
        this.nom = nom;
        this.numeroclient = numeroclient;
        return this;
    }


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

    public void CreerUnCompte(String nom,String prenom,String age,String Adresse , String mail, String pseudonyme, String motdepasse) {
        Connection conn = null;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        try {
            String requete="INSERT INTO `client`( `Nom`, `Prenom`, `Age`, `Adresse`, `Mail`) VALUES ('"+nom+"','"+prenom+"','"+age+"','"+Adresse+"','"+mail+"')";
            Statement st=conn.createStatement();
            int rs=st.executeUpdate(requete);
            if (rs>0){
                System.out.println("Le nombre de client ajouté à la base de donnée est de :"+rs);
            }
            if (rs==0){
                 System.out.println("Votre requete n'a apporté aucune modification.");
            }
            requete="SELECT NumeroClient from client WHERE Nom='"+nom+"' AND prenom='"+prenom+"'";
            st=conn.createStatement();
            ResultSet rss=st.executeQuery(requete);
            String numeroclient="";
            while (rss.next()){
                numeroclient=rss.getString("NumeroClient");
            }
            requete = "INSERT INTO compte (`NumeroClient`, `Mail`, `Pseudonyme`, `MotDePasse`) VALUES ('" + numeroclient + "','" + mail + "','" + pseudonyme + "','" + motdepasse + "')";
             st = conn.createStatement();
            System.out.println(requete);
            rs = st.executeUpdate(requete);
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

    public void AcheterUnBillet(String Categorie, String numeroseance, int numeroclient,String rangee, String allee) {
        Connection conn = null;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        
        try {
            String requete = "INSERT INTO billet (`Categorie`,`numeroseance`,`numeroclient`,`rangee`,`allee`) VALUES ('" + Categorie + "','" + numeroseance + "','" + numeroclient + "','" + rangee + "','" + allee + "')";
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
    
    public void AcheterUnBillet2(String Categorie, String numeroseance, String Nom, String Prenom,String rangee, String allee) {
        Connection conn = null;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        
        try {
            String requete = "INSERT INTO billetnonclient (`Categorie`,`NumeroSeance`,`Nom`,`Prenom`,`rangee`,`allee`) VALUES ('" + Categorie + "','" + numeroseance + "','" + Nom + "','" + Prenom + "','" + rangee + "','" + allee + "')";
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
                String cat = rs.getString("NumeroSeance");
                String numeroseance = rs.getString("Categorie");
                String rangee = rs.getString("Rangee");
                String allee = rs.getString("allee");
                System.out.println(ID + numeroseance + cat + rangee +allee);

                donnee[i][0] = ID;
                donnee[i][1] = numeroseance;
                donnee[i][2] = cat;
                donnee[i][3] = rangee;
                donnee[i][4] = allee;
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
    
    public int GetIDClient(String pseudo){
        Connection conn;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        int NumeroClient=0;
        try{
            String requete = "SELECT NumeroClient from compte WHERE Pseudonyme='"+pseudo+"'";
            
            System.out.println(requete);
            Statement st = conn.createStatement();
            ResultSet rs=st.executeQuery(requete);
            while (rs.next()){
                NumeroClient=rs.getInt("NumeroClient");
            }
            
        } catch (SQLException e) {
             System.out.println("Error Occured " + e.toString());
            
        }
        
        
        return NumeroClient; 
        
    }
}