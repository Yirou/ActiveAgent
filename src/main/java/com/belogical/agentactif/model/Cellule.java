/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belogical.agentactif.model;

/**
 *
 * @author yirou
 */
public class Cellule {

    private int x;
    private int y;
    private Content content;

    public Cellule(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Cellule(int x, int y, Content content) {
        this.x = x;
        this.y = y;
        this.content = content;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Cellule{" + "x=" + x + ", y=" + y + ", content=" + content + '}';
    }

}
