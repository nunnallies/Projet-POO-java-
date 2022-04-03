/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import Modele.Client;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author XPS
 */
public class HistoriqueClient extends JFrame implements ActionListener, ItemListener {

    private final JButton MonCompte;

    private final JPanel p0;

    public HistoriqueClient(String x) {
        super("Page d'accueil");
        setLayout(new BorderLayout());
        setBounds(0, 0, 700, 400);
        setResizable(true);
        setVisible(true);

        MonCompte = new JButton("Mon Compte");
        Client client = new Client();
        p0 = new JPanel();
        p0.add(MonCompte);
        p0.setLayout(new GridLayout(1, 3));
        String columns[] = {"NumeroBillet", "Categorie", "NumeroSeance", "Rangee", "allee"};
        DefaultTableModel snoopy;

        snoopy = new DefaultTableModel(client.getClientBillets(client.GetIDClient(x)), columns);

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
