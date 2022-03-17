/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Cinema;

import java.sql.*;
import projetjava.utils.*;

/**
 *
 * @author Naiss
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Connection conn=null;
        String url = "jdbc:mysql://localhost:3306/cinema";
        String user = "root";
        String password = "";
        System.out.println("Connecting database...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println("Connected successfully to the database");

        } catch (ClassNotFoundException e) {
            System.err.println("Driver loading error : " + e);
        } catch (Exception e) {
            System.out.println("Error Occured " + e.toString());
        }
       
        String requete = "INSERT INTO client (numeroclient,nom,prenom,age,adresse,mail) VALUES (4,'client 4','prenom 4',0,'none','non')";
        try {
            Statement stmt = conn.createStatement();
            int status = stmt.executeUpdate(requete);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
