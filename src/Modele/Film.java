/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

import static java.awt.image.ImageObserver.WIDTH;
import java.sql.*;
import java.util.*;
import javax.swing.ImageIcon;
import DAO.JDBConnector;

import vue.*;

import Vue.*;


/**
 *
 * @author Naiss
 */
public class Film {

    String Nom, Realisateur;
    String DateDeParution;
    String NoteDePresse, NoteDeSpec;
    String Synopsis;
    String MatriculeEmploye;
    String Duree;
    String path;

    public Film Film(String NomFilm, String Realisateur, String DateDeParution, String NoteDePresse, String NoteDeSpec, String Synopsis, String MatriculeEmploye,String Duree,String path) {
        this.Nom = NomFilm;
        this.Realisateur = Realisateur;
        this.MatriculeEmploye = MatriculeEmploye;
        this.DateDeParution = DateDeParution;
        this.NoteDePresse = NoteDePresse;
        this.NoteDeSpec = NoteDeSpec;
        this.Synopsis = Synopsis;
        this.path=path;
        this.Duree=Duree;
        
        return this;

    }

    public Object[][] getfilms() {
        Connection conn;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        ArrayList<Film> films= new ArrayList<Film>();
        int nb=0;
        try {
            PreparedStatement st = conn.prepareStatement("SELECT count(*) from film");
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
    
    public String GetID(String nom){
        Connection conn;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        String ID="";
        try{
            String requete = "SELECT IDFILM from film WHERE nom='"+nom+"'";
            System.out.println(requete);
            Statement st = conn.createStatement();
            ResultSet rs=st.executeQuery(requete);
            while (rs.next()){
                ID=rs.getString("IDFILM");
            }
            
        } catch (SQLException e) {
             System.out.println("Error Occured " + e.toString());
            
        }
        
        return ID; 
        
    }
}
