/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belogical.agentactif.model.views;

import com.belogical.agentactif.model.Cellule;
import com.belogical.agentactif.model.Content;
import com.belogical.agentactif.model.Environnement;
import com.belogical.agentactif.model.Objet;
import com.belogical.agentactif.model.agent.Agent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author yirou
 */
public class EnrinonnementView extends javax.swing.JFrame {

    Environnement environnement = Environnement.getInstance();
    List<JPanel> panels = new ArrayList<>();
    Dimension dimension = new Dimension(50, 50);

    /**
     * Creates new form EnrinonnementView
     */
    public EnrinonnementView() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelBackground.setLayout(new GridLayout(environnement.getNbLine(), environnement.getNbColumn(), 5, 5));
        initialize();
        this.setVisible(true);
    }

    private void initialize() {
        JPanel panel;
        for (int i = 0; i < environnement.getNbLine(); i++) {
            for (int j = 0; j < environnement.getNbLine(); j++) {
                panel = new JPanel();
                panel.setPreferredSize(dimension);
                panel.setBorder(new EtchedBorder());
                this.panelBackground.add(panel);
                Cellule cellule = environnement.getCellules()[i][j];
                displayCellulePanel(cellule, panel);
            }
        }
        this.validate();
    }

    private void displayCellulePanel(Cellule cellule, JPanel panel) {
        Content content = cellule.getContent();
        if (content != null) {
            displayByType(content, panel);

        }
    }

    private void displayByType(Content content, JPanel panel) {
        if (content instanceof Agent) {
            panel.setBackground(Color.GREEN);
        } else if (content instanceof Objet) {
            panel.setBackground(Color.ORANGE);
        }
    }

    public Environnement getEnvironnement() {
        return environnement;
    }

    public void setEnvironnement(Environnement environnement) {
        this.environnement = environnement;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelBackgroundLayout = new javax.swing.GroupLayout(panelBackground);
        panelBackground.setLayout(panelBackgroundLayout);
        panelBackgroundLayout.setHorizontalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 729, Short.MAX_VALUE)
        );
        panelBackgroundLayout.setVerticalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel panelBackground;
    // End of variables declaration//GEN-END:variables

}
