/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belogical.agentactif.model;

import com.belogical.agentactif.model.views.EnrinonnementView;

/**
 *
 * @author yirou
 */
public class Main {

     Environnement environnement;

    public Main() {
        environnement = Environnement.getInstance();
        environnement.setNbLine(10);
        environnement.setNbColumn(10);
        environnement.initialize();
    }

    public static void main(String argv[]) {
        new Main();
        EnrinonnementView view =new EnrinonnementView();
        view.setEnvironnement(Environnement.getInstance());
        
    }
}
