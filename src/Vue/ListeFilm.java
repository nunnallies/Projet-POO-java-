/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import Modele.Film;
import Modele.Seance;
import java.awt.event.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import javax.swing.table.DefaultTableModel;

/**
 *
 *
 * @author Naiss
 */
public class ListeFilm extends JFrame implements ActionListener, ItemListener, ListSelectionListener {

    private final JButton MonCompte;

    private final JPanel p0;
    private JTable table;
    final JFrame frame = new JFrame("Liste Des séances");

    public Class getcolumns(int column) {
        return (column == 1) ? Icon.class : Object.class;
    }

    public ListeFilm() {
        super("Page d'accueil");
        setLayout(new BorderLayout());
        setBounds(0, 0, 700, 400);
        setResizable(true);
        setVisible(true);

        MonCompte = new JButton("Mon Compte");
        Film film = new Film();

        p0 = new JPanel();
        p0.add(MonCompte);
        p0.setLayout(new GridLayout(1, 3));
        String columns[] = {"Affiche", "Nom", "Realisateur", "Duree", "Synopsis", "Date de parution", "Note de presse", "Note de spectateurs"};

        DefaultTableModel snoopy;

        snoopy = new DefaultTableModel(film.getfilms(), columns);

        JTable table = new JTable(snoopy);
        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                int a = table.getSelectedRow();
                System.out.println(a);
                Film film = new Film();
                Seance seances = new Seance();
                Object[][] donnee = film.getfilms();
                String colonne[] = {"Numero Seance", "Nom", "NumeroSalle", "Date", "Heure", "Duree seance"};
                DefaultTableModel seance;
                seance = new DefaultTableModel(seances.getSeanceFilm((String) donnee[a][9]), colonne);
                JTable table = new JTable(seance);
                JScrollPane scrollPane = new JScrollPane(table);
                JLabel labelHead = new JLabel("Liste des employes");
                labelHead.setFont(new Font("Times New Roman", Font.TRUETYPE_FONT, 20));

                frame.getContentPane().add(labelHead, BorderLayout.PAGE_START);
                //ajouter la table au frame
                frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(700, 400);
                frame.setVisible(true);

                // System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
        table.setShowGrid(false);
        table.setShowVerticalLines(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        int a = table.getSelectedRow();
        System.out.println(a);
        Film film = new Film();
        Seance seances = new Seance();
        Object[][] donnee = film.getfilms();
        String colonne[] = {"Numero Seance", "Nom", "NumeroSalle", "Date", "Heure", "Duree seance"};
        DefaultTableModel seance;
        seance = new DefaultTableModel(seances.getSeanceFilm((String) donnee[a][9]), colonne);
        JTable table = new JTable(seance);
        JScrollPane scrollPane = new JScrollPane(table);
        JLabel labelHead = new JLabel("Liste des employes");
        labelHead.setFont(new Font("Times New Roman", Font.TRUETYPE_FONT, 20));

        frame.getContentPane().add(labelHead, BorderLayout.PAGE_START);
        //ajouter la table au frame
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setVisible(true);

    }

            @Override
            public void valueChanged(ListSelectionEvent event) {
                int a = table.getSelectedRow();
                System.out.println(a);
                Film film = new Film();
                Seance seances = new Seance();
                Object[][] donnee = film.getfilms();
                String colonne[] = {"Numero Seance", "Nom", "NumeroSalle", "Date", "Heure", "Duree seance"};
                DefaultTableModel seance;
                seance = new DefaultTableModel(seances.getSeanceFilm((String) donnee[a][9]), colonne);
                JTable table = new JTable(seance);
                JScrollPane scrollPane = new JScrollPane(table);
                JLabel labelHead = new JLabel("Liste des employes");
                labelHead.setFont(new Font("Times New Roman", Font.TRUETYPE_FONT, 20));

                frame.getContentPane().add(labelHead, BorderLayout.PAGE_START);
                //ajouter la table au frame
                frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(700, 400);
                frame.setVisible(true);

                // System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
            }
    
}
