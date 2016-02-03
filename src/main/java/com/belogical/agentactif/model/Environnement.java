/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belogical.agentactif.model;

import com.belogical.agentactif.model.agent.Agent;
import com.belogical.agentactif.model.agent.TypeAgent;
import com.belogical.agentactif.model.factory.FactoryAgent;
import com.belogical.agentactif.model.factory.FactoryObjet;
import java.util.Random;

/**
 *
 * @author yirou
 */
public class Environnement {

    private Content[] contents;
    private Cellule[][] cellules;
    private int nbAgent = 3;
    private int nbObjet = 5;
    private int nbLine;
    private int nbColumn;
    private static final Environnement instance = new Environnement();

    private Environnement() {
        contents = new Content[nbAgent + nbObjet];
    }

    public static Environnement getInstance() {
        return instance;
    }

    public int getNbAgent() {
        return nbAgent;
    }

    public void setNbAgent(int nbAgent) {
        this.nbAgent = nbAgent;
    }

    public Content[] getContents() {
        return contents;
    }

    public void setContents(Content[] contents) {
        this.contents = contents;
    }

    public int getNbObjet() {
        return nbObjet;
    }

    public void setNbObjet(int nbObjet) {
        this.nbObjet = nbObjet;
    }

    public void initialize() {

        cellules = new Cellule[nbLine][nbColumn];
        Agent agent;
        Objet objet;
        Cellule cellule;
        /**
         * *
         * Initialize Cellule
         */
        for (int i = 0; i < nbLine; i++) {
            for (int j = 0; j < nbColumn; j++) {
                cellule = new Cellule(i, j);
                cellules[i][j] = cellule;
            }
        }
        /**
         * Initialize Agent
         */

        for (int i = 0; i < nbAgent; i++) {
            int type = random(0, TypeAgent.values().length);
            TypeAgent typeAgent = TypeAgent.values()[type];
            agent = FactoryAgent.getInstance().createAgent(typeAgent);
            int x = random(0, nbLine - 1);
            int y = random(0, nbColumn - 1);
            cellules[x][y].setContent(agent);
            contents[i] = agent;
        }
        /**
         * Initialize Objet
         *
         */
        for (int i = 0; i < nbObjet; i++) {
            int type = random(0, TypeObjet.values().length);
            TypeObjet typeObjet = TypeObjet.values()[type];
            objet = FactoryObjet.getInstance().createObjet(typeObjet);
            int x = random(0, nbLine - 1);
            int y = random(0, nbColumn - 1);
            cellules[x][y].setContent(objet);
            contents[nbAgent + i] = objet;
        }
    }

    private int random(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public void display() {
        for (int i = 0; i < nbLine; i++) {
            for (int j = 0; j < nbColumn; j++) {

            }
        }
    }

    public Environnement clone(Environnement environnement) {
        return null;
    }

    

    public Cellule[][] getCellules() {
        return cellules;
    }

    public void setCellules(Cellule[][] cellules) {
        this.cellules = cellules;
    }

    public int getNbLine() {
        return nbLine;
    }

    public void setNbLine(int nbLine) {
        this.nbLine = nbLine;
    }

    public int getNbColumn() {
        return nbColumn;
    }

    public void setNbColumn(int nbColumn) {
        this.nbColumn = nbColumn;
    }

}
