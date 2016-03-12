/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belogical.agentactif.model.agent;

import com.belogical.agentactif.model.Cellule;
import com.belogical.agentactif.model.Content;
import com.belogical.agentactif.model.Empty;
import com.belogical.agentactif.model.Environnement;
import com.belogical.agentactif.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yirou
 */
public abstract class Agent extends Content implements Runnable {
    
    protected boolean alive = true;
    protected Thread thread;
    protected Cellule celluleCourant;

    public Agent(String name) {
        super(name);
        thread = new Thread(this);
        thread.start();
    }

    public Cellule getCelluleCourant() {
        return celluleCourant;
    }

    public void setCelluleCourant(Cellule celluleCourant) {
        this.celluleCourant = celluleCourant;
    }

    public List<Cellule> checkFreeCellule() {
        Environnement environnement = Environnement.getInstance();
        Lock l = new ReentrantLock();
        List<Cellule> results = new ArrayList<>();
        int x, y;
        boolean isAgent;
        l.lock();
        try {
            List<Integer> decallage = Arrays.asList(-1, 0, 1);
            for (int i : decallage) {
                for (int j : decallage) {
                    x = i + this.getCelluleCourant().getX();
                    y = j + this.getCelluleCourant().getY();
                    if ((x >= 0 && y >= 0) && (x != celluleCourant.getX() || (y != celluleCourant.getY())) && (x < environnement.getNbLine()) && (y < environnement.getNbColumn())) {
//                        System.out.println("X " + (i + this.getCelluleCourant().getX()) + ", Y " + (this.getCelluleCourant().getY() + j));
                        isAgent = environnement.getCellules()[x][y].getContent() instanceof Agent;
                        if (!isAgent) {
                            results.add(environnement.getCellules()[x][y]);
                        }

                    }
                }
            }
        } finally {
            l.unlock();
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
        Cellule cellule;
        while (alive) {
            try {
                Thread.sleep(3000);
                List<Cellule> nearby = checkFreeCellule();
                if (nearby.size() > 0) {
                    System.out.println("Mes voisins " + nearby.size() + " | " + nearby.toString());
                    int cel = Utils.random(0, nearby.size());
                    cellule=this.getCelluleCourant();
                    cellule.setContent(new Empty("Empty"));
                    cellule=nearby.get(cel);
                    this.setCelluleCourant(cellule);
                    double pheromone = cellule.getPheromone()+30;
                    cellule.setPheromone(pheromone);
//                    System.out.println("pheromone " + cellule.getPheromone());
//                    System.out.println("nearby " + nearby.size() + " Now cellule " + cel + " = " + nearby.get(cel).getX() + " , " + nearby.get(cel).getY());
                    nearby.get(cel).setContent(this);
                    this.setChanged();
                    this.notifyObservers();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Agent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
