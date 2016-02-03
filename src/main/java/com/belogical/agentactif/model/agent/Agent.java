/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belogical.agentactif.model.agent;

import com.belogical.agentactif.model.Content;

/**
 *
 * @author yirou
 */
public abstract class Agent extends Content {

    public Agent(String name) {
        super(name);
    }

    public void init() {

    }

    public void next() {

    }

    public void terminate() {

    }
}
