/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belogical.agentactif.model.agent;

import com.belogical.agentactif.model.Cellule;
import com.belogical.agentactif.model.Content;
import com.belogical.agentactif.model.Environnement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yirou
 */
public abstract class Agent extends Content implements Runnable {

    private boolean alive;
    private Thread thread;
    private Cellule celluleCourant;

    public Agent(String name) {
        super(name);
        thread = new Thread(this);
    }

    public Cellule getCelluleCourant() {
        return celluleCourant;
    }

    public void setCelluleCourant(Cellule celluleCourant) {
        this.celluleCourant = celluleCourant;
    }

    public List<Cellule> checkFreeCellule(Environnement environnement) {
        List<Cellule> results = new ArrayList<>();
        List<Integer> decallage = Arrays.asList(-1, 0, 1);
        for (int i : decallage) {
            for (int j : decallage) {
                if (i + this.getCelluleCourant().getX() <= environnement.getNbLine() && j + this.getCelluleCourant().getY() <= environnement.getNbColumn()) {
                    results.add(environnement.getCellules()[this.getCelluleCourant().getX() + i][this.getCelluleCourant().getY() + j]);
                }
            }
        }

        return results;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public void init() {

    }

    public void next() {

    }

    public void terminate() {

    }

    @Override
    public void run() {
        while (alive) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Agent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
