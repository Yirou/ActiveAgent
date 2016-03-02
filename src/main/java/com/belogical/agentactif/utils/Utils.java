/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belogical.agentactif.utils;

import java.util.Random;

/**
 *
 * @author yirou
 */
public class Utils {

    public static int random(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
