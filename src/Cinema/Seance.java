/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cinema;
import java.util.*;

/**
 *
 * @author Naiss
 */
public class Seance {
    int numerosalle,heure,duree;
    Date date;
    String lieu;
    
    Seance(String lieu,Date date, int heure,int duree,int numerosalle){
        this.date=date;
        this.numerosalle=numerosalle;
        this.duree=duree;
        this.lieu=lieu;
        this.heure=heure;
    }
    
}
