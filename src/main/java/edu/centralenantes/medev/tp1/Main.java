package edu.centralenantes.medev.tp1;

import java.util.Scanner;

public class Main {

  private static final int FORTUNE_INITAL = 100000;

  public static void main(String[] args) {
    // initialiser le plateau
    Plateau p = new Plateau();
    Scanner sc = new Scanner(System.in);
    p.initPlateau();
    // Demander le nombre de joueurs
    System.out.println("Bienvenue sur Monopoly à Centrale Nantes");
    System.out.println("À combien de joueurs voulez-vous jouer ?");

    try {
      String s = sc.next();
      int nbJoueurs = Integer.parseInt(s);
      for (int i = 0; i < nbJoueurs; i++) {
        // Creation des joueurs en demandant leurs caracteristiques
        System.out.println("Pour le joueur " + (i + 1) + "\nEntrez votre nom, s'il vous plait.");
        String nom = sc.next();
        int position = 0;
        Joueur j = new Joueur(nom, FORTUNE_INITAL, position, p);
        // ajouter le joueur a la liste dans plateau
        p.getListeJoueurs().add(j);
      }
      //Affichage
      p.affiche();

      //Tour de Jeu
      boolean jeuFini = false;
      int tourDeJeu = 1;
      while (!jeuFini) {
        System.out.println("\n TOUR n°: " + tourDeJeu);
        p.tourDeJeu();
        System.out.println();
        p.affiche();
        jeuFini = p.getListeJoueurs().size() <= 1;
        tourDeJeu += 1;

        if (!continuerLeJeu(sc)) {
          jeuFini = true;
        }

      }
      //Jeu fini
      System.out.println("Le jeu est fini.");
    } catch (Exception e) {
      System.err.println(e.getMessage());
      if (sc != null) {
        sc.close();
      }
      System.exit(1);
    }
  }

  /**
   * retourne false si le joueur veut quitter le jeu
   *
   * @param sc Scanner sc
   * @return
   */
  public static boolean continuerLeJeu(Scanner sc) {
    System.out.println("\n Voulez-vous continuer (C) ou quitter le jeu (Q)");
    String choix = sc.next();
    return !choix.equals("Q");
  }
}
