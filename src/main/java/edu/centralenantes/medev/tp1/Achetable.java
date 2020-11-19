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
public abstract class Achetable extends Case{
    
    public Joueur proprietaire;
    public int prix;
    
    public Achetable(String nom, int prix) {
        super(nom);
        this.prix = prix;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    
    
    
    public void acheter(Joueur acheteur) {
        
        try{acheteur.paiement(null,this.prix);}
            catch(Exception e){
                  System.out.println(e.getMessage());     
                }
        
        this.proprietaire = acheteur;
    }
    
    public abstract int getPrixLoyer();
    
    @Override
    public String toString() {
        String ret = this.nom + " (coût : " + this.prix + "€)";
        if (this.proprietaire != null){
            ret += " - propriétaire : " + this.proprietaire;
        }else{
            ret += " - sans propriétaire";
        }
        return ret;
    }
    
}
