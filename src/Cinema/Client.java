/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cinema;

/**
 *
 * @author Naiss
 */
public class Client {
    
    String nom,prenom,adresse,mail;
    int age,numeroclient;
    
    //Constructeur
    public Client(int numeroclient,String nom,String prenom,String adresse,String mail,int age){
        this.numeroclient=numeroclient;
        this.nom=nom;
        this.prenom=prenom;
        this.adresse=adresse;
        this.mail=mail; 
        this.age=age;
    }
    
}
