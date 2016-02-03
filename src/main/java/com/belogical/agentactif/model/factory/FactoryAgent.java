/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belogical.agentactif.model.factory;

import com.belogical.agentactif.model.agent.Agent;
import com.belogical.agentactif.model.agent.AgentEscavateur;
import com.belogical.agentactif.model.agent.AgentExplorateur;
import com.belogical.agentactif.model.agent.AgentTransporteur;
import com.belogical.agentactif.model.agent.TypeAgent;

/**
 *
 * @author yirou
 */
public class FactoryAgent {

    private static final FactoryAgent instance = new FactoryAgent();

    private FactoryAgent() {
    }

    public static FactoryAgent getInstance() {
        return instance;
    }

    public Agent createAgent(TypeAgent type) {
        Agent agent;
        switch (type) {
            case AgentExplorateur:
                agent = new AgentExplorateur("Agent Explorateur");
                break;

            case AgentTransporteur:
                agent = new AgentTransporteur("Agent Transporteur");
                break;

            case AgentEscavateur:
                agent = new AgentEscavateur("AgentEscavateur");
                break;

            default:
                agent = new AgentExplorateur("Agent Explorateur");
                break;
        }
        return agent;
    }
}
