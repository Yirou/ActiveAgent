/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belogical.agentactif.model;

import java.util.Observable;

/**
 *
 * @author yirou
 */
public abstract class Content extends Observable {

    protected String name;
    

    public Content(String name) {
        this.name = name;
    }

}
