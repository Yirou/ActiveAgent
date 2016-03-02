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
import com.belogical.agentactif.utils.Utils;

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
        contents = new Content[nbAgent + nbObjet];
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
                /**
                 * On met tous les champs à empty
                 */
                cellule.setContent(new Empty("Empty"));
                cellules[i][j] = cellule;
            }
        }
        /**
         * Initialize Agent
         */

        for (int i = 0; i < nbAgent; i++) {
            /**
             * On choisi un type au hasard
             */
            int type = Utils.random(0, TypeAgent.values().length);
            TypeAgent typeAgent = TypeAgent.values()[type];
            agent = FactoryAgent.getInstance().createAgent(typeAgent);
            cellule = getRandomFreeCell();
            cellule.setContent(agent);
            agent.setCelluleCourant(cellule);
            contents[i] = agent;
        }
        /**
         * Initialize Objet
         *
         */
        for (int i = 0; i < nbObjet; i++) {
            int type = Utils.random(0, TypeObjet.values().length);
            TypeObjet typeObjet = TypeObjet.values()[type];
            objet = FactoryObjet.getInstance().createObjet(typeObjet);
            cellule = getRandomFreeCell();
            cellule.setContent(objet);
            contents[nbAgent + i] = objet;
        }
    }

    public void display() {
        for (int i = 0; i < nbLine; i++) {
            for (int j = 0; j < nbColumn; j++) {

            }
        }
    }

    public Environnement clone(Environnement environnement) {
        return environnement;
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

    private Cellule getRandomFreeCell() {
        Content content;
        int x;
        int y;
        boolean isInstanceOf;
        do {
            x = Utils.random(0, nbLine);
            y = Utils.random(0, nbColumn);
            System.out.println("random " + x + " , " + y);
            content = cellules[x][y].getContent();
            isInstanceOf = content instanceof Empty;
        } while (!isInstanceOf);
        return cellules[x][y];
    }

}
