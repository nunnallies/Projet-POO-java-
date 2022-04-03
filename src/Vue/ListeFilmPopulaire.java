/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import Modele.Film;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Naiss
 */
public class ListeFilmPopulaire extends JFrame implements ActionListener , ItemListener  {
    private final JButton MonCompte;

    private final JPanel p0;

    public Class getcolumns(int column) {
        return (column == 1) ? Icon.class : Object.class;
    }

    public ListeFilmPopulaire() {
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
        String columns[] = {"Affiche", "Nom", "Realisateur", "Duree", "Synopsis", "Date de parution", "Note de presse", "Note de spectateurs","Nombre Spectateur","IDFILM","Employe"};

        DefaultTableModel snoopy;

        snoopy = new DefaultTableModel(film.getfilmsPopulaire(), columns);

        JTable table = new JTable(snoopy);

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    
}
