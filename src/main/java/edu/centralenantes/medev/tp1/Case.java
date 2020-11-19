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
public abstract class Case {

    public String nom;    
        
    public Case(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    @Override
    public String toString(){  
        String ret = this.nom;
        
        return ret;
    }
}
