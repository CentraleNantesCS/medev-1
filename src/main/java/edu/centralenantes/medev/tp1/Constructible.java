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
public class Constructible extends Achetable {
    
    public int nbMaisons;
    public int nbHotels;
    
    
    public Constructible(String nom, int prix) {
        super(nom, prix);
    }

    @Override
    public int getPrixLoyer(){
        
        int a = 500;
        int b = 1000;
        
        if(this.proprietaire == null){
            return 0;
        }
        return nbMaisons * a + nbHotels * b + 500;
    }

    @Override
    public String toString() {
        if(this.proprietaire == null){
            return this.toString();
        }
        String ret = this.toString();
        if(nbMaisons > 0){
            ret += ", " + nbMaisons + "maisons";
        }
        if(nbHotels > 0){
            ret += ", " + nbHotels + "hotels";
        }
        return ret + ", loyer = " + this.getPrixLoyer() + "€";
    }
    
}