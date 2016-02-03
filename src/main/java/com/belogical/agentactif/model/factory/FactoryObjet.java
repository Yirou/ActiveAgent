/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belogical.agentactif.model.factory;

import com.belogical.agentactif.model.Minerai;
import com.belogical.agentactif.model.Objet;
import com.belogical.agentactif.model.Rocher;
import com.belogical.agentactif.model.TypeObjet;

/**
 *
 * @author yirou
 */
public class FactoryObjet {

    private static final FactoryObjet instance = new FactoryObjet();

    private FactoryObjet() {
    }

    public static FactoryObjet getInstance() {
        return instance;
    }

    public Objet createObjet(TypeObjet type) {
        Objet objet;
        switch (type) {
            case Minerai:
                objet = new Minerai("Minerai");
                break;

            case Rocher:
                objet = new Rocher("Rocher");
                break;

            default:
                objet = new Minerai("Minerai");
                break;
        }
        return objet;
    }
}
