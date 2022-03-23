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
public class Film {
String Nom,Realisateur;
Date DateDeParution;
float NoteDePresse,NoteDeSpec;
String Synopsis;
int MatriculeEmploye;

public Film(String NomFilm,String Realisateur,Date DateDeParution,float NoteDePresse,float NoteDeSpec,String Synopsis,int MatriculeEmploye){
    this.Nom=NomFilm; 
    this.Realisateur=Realisateur;
    this.MatriculeEmploye=MatriculeEmploye;
    this.DateDeParution=DateDeParution;
    this.NoteDePresse=NoteDePresse;
    this.NoteDeSpec=NoteDeSpec;
    this.Synopsis=Synopsis; 
    
}


}
