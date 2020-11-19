/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.medev.tp1;

/**
 *
 * @author hayth
 */
public class Gare extends Achetable {

    public Gare(String nom, int prix) {
        super(nom, prix);
    }

    @Override
    public int getPrixLoyer(){
        
        if(this.proprietaire == null){
            return 0;
        }
        return this.proprietaire.plateau.getNbGares(this.proprietaire)*2500;
    }

    @Override
    public String toString() {
        if(this.proprietaire == null){
            return this.toString();
        }
        return this + ", loyer = " + this.getPrixLoyer() + "€";
    }
    
    
}
