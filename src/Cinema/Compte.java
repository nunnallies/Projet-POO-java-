/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cinema;
import java.sql.*;


/**
 *
 * @author Naiss
 */
public class Compte   {
    int numerocompte,numeroclient,age; 
    String MotDePasse,pseudonyme;
    String nom, prenom, adresse, mail;
    
    Compte (int numerocompte,int numeroclient,String nom,String prenom,int age, String adresse,String mail,String pseudonyme,String MotDePasse){
        this.prenom=prenom; 
        this.pseudonyme=pseudonyme;
        this.adresse=adresse; 
        this.age=age;
        this.mail=mail;
        this.MotDePasse=MotDePasse;
        this.numeroclient=numeroclient;
        this.numerocompte=numerocompte;
        this.nom=nom;
    }
   
    
 }
