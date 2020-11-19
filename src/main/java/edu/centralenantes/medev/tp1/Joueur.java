package edu.centralenantes.medev.tp1;

import edu.centralenantes.medev.tp1.Achetable;
import edu.centralenantes.medev.tp1.Case;
import edu.centralenantes.medev.tp1.Constructible;
import edu.centralenantes.medev.tp1.plateau.Plateau;

/**
 *
 * @author
 */
public class Joueur {

    private String nom;
    private int fortune;
    private int position;
    private Plateau plateau;

    public Joueur(){
        this.nom = "";
        this.fortune = 100000;
        this.position = 0;
        this.plateau = new Plateau();
    }

    public Joueur(String name,int fortune, int pos, Plateau plat){
        this.nom = name;
        this.fortune = fortune;
        this.position = pos;
        this.plateau = plat;
    }

    public void avance(int d){
        if(this.position + d >39){
            this.position = this.position + d - 40;
        }else{
            this.position += d;
        }
    }

    public void paiement(Joueur j, int montant){
        if (j==null){ // On paie la banque
            if(this.fortune < montant){
                //noMoremOney("Paiement ..");
        }else{
            this.fortune -= montant;
        }
        }else{ // On paie un joueur
        if(this.fortune < montant){
            // Exception NoMoreMoney ?
        }else{
            j.setFortune(j.getFortune() + montant);
            this.fortune -= montant;
        }
        }
    }

    public static int lanceLeDe() {
      return ((int) Math.floor(Math.random()*6))+1;
    }

    public void monTourDeJeu(){ // Classe Joueur
        int valeur = lanceLeDe();
        this.avance(valeur);
        Case caseCourante = this.plateau.getPlateau().get(this.position);
        System.out.println("Le joueur " + this.nom + " se trouve sur la case " + caseCourante.getNom());

        if (caseCourante instanceof Achetable){ // Case achetable
            if(caseCourante.getProprietaire() == null){ // Cas où la case n'appartient pas encore à un joueur
                if(caseCourante.getPrix() < this.fortune && valeur%2==1){ // Le joueur l'achète si la valeur du dé est impaire et...
                    caseCourante.setProprietaire(this);
                    this.fortune -= caseCourante.getPrix();
                }
            }else{ // Cas où la case appartient à un joueur
                if(caseCourante.getProprietaire() == this && caseCourante instanceof Constructible){ //Notre case
                    caseCourante.construire();
                }else{ // La case d'un autre joueur
                paiement(caseCourante.getProprietaire());
                }
            }
        }
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getFortune() {
        return fortune;
    }

    public void setFortune(int fortune) {
        this.fortune = fortune;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Plateau getPlateau() { // pb
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }



}


