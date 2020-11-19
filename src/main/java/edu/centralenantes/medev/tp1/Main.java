package edu.centralenantes.medev.tp1;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("Bienvenue sur Monopoly à Centrale Nantes");
    System.out.println("À combien de joueurs voulez-vous jouer ?");
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    int nbJoueurs = Integer.parseInt(s);
    for(int i=0; i<nbJoueurs; i++){
      System.out.println("On commence par le joueur "+(i+1)+"\nEntrez le nom de votre joueur, s'il vous plait.");
      String s = sc.next();
      
    }
  }
}
