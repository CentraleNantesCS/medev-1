package edu.centralenantes.medev.tp1;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    //initialiser le plateau
    Plateau p = new Plateau();
    
    //Demander le nombre de joueurs
    System.out.println("Bienvenue sur Monopoly à Centrale Nantes");
    System.out.println("À combien de joueurs voulez-vous jouer ?");
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    int nbJoueurs = Integer.parseInt(s);
    
    //Creation des joueurs en demandant leurs caracteristiques
    for(int i=0; i<nbJoueurs; i++){
      System.out.println("On commence par le joueur "+(i+1)+"\nEntrez votre nom, s'il vous plait.");
      String nom = sc.next();
      int fortune = 100000;
      int position = 0;
      //ajouter le joueur a la liste dans plateau
      Joueur j = new Joueur(nom,fortune,position,p);
      p.joueurs.add(j);
    }
    
    //Affichage
    p.affiche();
    
    //Tour de Jeu
    boolean jeuFini = false;
    while(!jeuFini){
      p.tourDeJeu();
      p.affiche();
      jeuFini = p.finDePartie();
    }
    
    //Jeu fini
    System.out.println("Le jeu est fini.");
  }
}
