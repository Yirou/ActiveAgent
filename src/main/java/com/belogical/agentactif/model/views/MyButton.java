/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belogical.agentactif.model.views;

import com.belogical.agentactif.model.Cellule;
import com.belogical.agentactif.model.Content;
import com.belogical.agentactif.model.Environnement;
import com.belogical.agentactif.model.Minerai;
import com.belogical.agentactif.model.Objet;
import com.belogical.agentactif.model.Rocher;
import com.belogical.agentactif.model.agent.Agent;
import com.belogical.agentactif.model.agent.AgentEscavateur;
import com.belogical.agentactif.model.agent.AgentExplorateur;
import com.belogical.agentactif.model.agent.AgentTransporteur;
import com.belogical.agentactif.model.agent.TypeAgent;
import java.awt.Color;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author yirou
 */
public class MyButton extends JButton implements Observer {

    private Cellule cellule;
    int indiceColor = 250;
    private Color color = new Color(237, 237, 237);

    public MyButton(Cellule cellule) {
        this.cellule = cellule;
    }

    public Cellule getCellule() {
        return cellule;
    }

    public void setCellule(Cellule cellule) {
        this.cellule = cellule;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void displayCellule() {
        Content content = cellule.getContent();
        if (content != null) {
            displayByType(content, this);
            addObserver(content);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        Agent agent;
        if (o instanceof Agent) {
//            System.out.println("changed " + this.getIcon());
            this.removeAll();
            this.setIcon(null);
            calculBtnColor(this);
            agent = (Agent) o;
            MyButton btn = EnvironnementView.getInstance().getButtons().get((agent.getCelluleCourant().getX() * Environnement.getInstance().getNbColumn()) + agent.getCelluleCourant().getY());
            btn.setCellule(agent.getCelluleCourant());
//            System.out.println("Panel " + (agent.getCelluleCourant().getX() + agent.getCelluleCourant().getY()));
            agent.deleteObservers();
            agent.addObserver(btn);
            displayByType(agent, btn);
//            this.validate();
//            this.setBackground(Color.BLUE);

        }
    }

    private void addObserver(Content content) {
        if (content instanceof Agent) {
            Agent agent = (Agent) content;
            agent.addObserver(this);
        }
    }

    private void displayByType(Content content, MyButton btn) {
        ImageIcon img = null;
        Image image;
        if (content instanceof Agent) {
            Agent agent = (Agent) content;
            if (agent instanceof AgentEscavateur) {
                img = new ImageIcon(EnvironnementView.urlAgentEscavateur);
            } else if (agent instanceof AgentExplorateur) {
                img = new ImageIcon(EnvironnementView.urlAgentExplorateur);
            } else if (agent instanceof AgentTransporteur) {
                img = new ImageIcon(EnvironnementView.urlAgentTransporteur);
            }

            image = img.getImage();
            Image imageNew = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
            btn.setIcon(new ImageIcon(imageNew));

        } else if (content instanceof Objet) {
            if (content instanceof Minerai) {
                img = new ImageIcon(EnvironnementView.urlMinerai);
            } else if (content instanceof Rocher) {
                img = new ImageIcon(EnvironnementView.urlRocher);
            }
            image = img.getImage();
            Image imageNew = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
            btn.setIcon(new ImageIcon(imageNew));
            btn.setBackground(Color.WHITE);
        } else {
            calculBtnColor(btn);
        }
    }

    private void calculBtnColor(MyButton btn) {
        int ph = (int) cellule.getPheromone();
        int r;
        int g;
        int b;
        if (ph >= 250) {
            cellule.setPheromone(1);
            r = 250;
            g = indiceColor - (int) cellule.getPheromone();
            b = indiceColor - (int) cellule.getPheromone();
            color = new Color(r, g, b);
        }else{
            int c = indiceColor - ph;
            color = new Color(c, c, c);
        }

        
        btn.setBackground(color);
//        if (ph >= 237) {
//            cellule.setPheromone(1);
//            indiceColor = 252;
//        }
    }
}
