package edu.centralenantes.medev.tp1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Plateau {

  public static int TAILLE = 10;

  private ArrayList<Case> listeCases;

  private LinkedList<Joueur> listeJoueurs;

  public ArrayList<Case> getListeCases() {
    return this.listeCases;
  }

  public void setListeCases(ArrayList<Case> listeCases) {
    this.listeCases = listeCases;
  }

  public LinkedList<Joueur> getListeJoueurs() {
    return this.listeJoueurs;
  }

  public void setListeJoueurs(LinkedList<Joueur> listeJoueurs) {
    this.listeJoueurs = listeJoueurs;
  }

  /*
   * Tour de jeu du plateau (boucle principale)
   */
  public void tourDeJeu() {
    for (Joueur j : listeJoueurs) {
      j.monTourDeJeu();
    }
    elimineJoueurs();
  }

  /*
   * Fonction de suppression des joueurs fauchés
   */
  public void elimineJoueurs() {
    Iterator<Joueur> iter = listeJoueurs.iterator();
    List<Joueur> joueursToRemove = new ArrayList<>();
    while (iter.hasNext()) {
      Joueur j = iter.next();
      if (j.getFortune() <= 0) {
        System.out.printf("le joueur %s a perdu \n", j.getNom());
        joueursToRemove.add(j);
      }
    }
    listeJoueurs.removeAll(joueursToRemove);
  }

  public void initPlateau() {
    listeCases = new ArrayList<>();

    // Première ligne (commence à la case départ)
    listeCases.add(new NonAchetable("case départ"));
    listeCases.add(new Constructible("marron 1", 60));
    listeCases.add(new NonAchetable("communauté"));
    listeCases.add(new Constructible("marron 2", 60));
    listeCases.add(new NonAchetable("taxe 1"));
    listeCases.add(new Gare("Gare 1", 200));
    listeCases.add(new Constructible("bleu clair 1", 100));
    listeCases.add(new NonAchetable("chance"));
    listeCases.add(new Constructible("bleu clair 2", 100));
    listeCases.add(new Constructible("bleu clair 3", 120));

    // Deuxième ligne (commence à la case visite prison)
    listeCases.add(new NonAchetable("visite prison"));
    listeCases.add(new Constructible("violet 1", 140));
    listeCases.add(new Compagnie("compagnie elec", 150));
    listeCases.add(new Constructible("violet 2", 140));
    listeCases.add(new Constructible("violet 3", 160));
    listeCases.add(new Gare("Gare 2", 200));
    listeCases.add(new Constructible("orange 1", 180));
    listeCases.add(new NonAchetable("communauté"));
    listeCases.add(new Constructible("orange 2", 180));
    listeCases.add(new Constructible("orange 3", 200));

    // Troisième ligne (commence à la case parc)
    listeCases.add(new NonAchetable("parc gratuit"));
    listeCases.add(new Constructible("rouge 1", 220));
    listeCases.add(new NonAchetable("chance"));
    listeCases.add(new Constructible("rouge 2", 220));
    listeCases.add(new Constructible("rouge 3", 240));
    listeCases.add(new Gare("Gare 3", 200));
    listeCases.add(new Constructible("jaune 1", 260));
    listeCases.add(new Constructible("jaune 2", 260));
    listeCases.add(new Compagnie("compagnie eau", 150));
    listeCases.add(new Constructible("jaune 3", 280));

    // Quatrième ligne (commence à la case allez en prison)
    listeCases.add(new NonAchetable("allez en prison"));
    listeCases.add(new Constructible("vert 1", 300));
    listeCases.add(new Constructible("vert 2", 300));
    listeCases.add(new NonAchetable("communauté"));
    listeCases.add(new Constructible("vert 3", 320));
    listeCases.add(new Gare("Gare 4", 200));
    listeCases.add(new Constructible("chance", 100));
    listeCases.add(new Constructible("bleu foncé 1", 350));
    listeCases.add(new NonAchetable("taxe 2"));
    listeCases.add(new Constructible("bleu foncé 2", 400));
    listeJoueurs = new LinkedList<>();
  }

  /**
   * retourne le nombre de gares
   */
  public int getNbGares(Joueur j) {
    int result = 0;
    int garesIndexes[] = { 5, 15, 25, 35 };
    for (int index : garesIndexes) {
      Gare g = (Gare) listeCases.get(index);
      if (g.getProprietaire() == j) {
        result++;
      }
    }
    return result;
  }

  /**
   * retourne le nombre de gares
   */
  public int getNbCompany(Joueur j) {
    int result = 0;
    int companyIndexes[] = { 12, 28 };
    for (int index : companyIndexes) {
      Compagnie c = (Compagnie) listeCases.get(index);
      if (c.getProprietaire() == j) {
        result++;
      }
    }
    return result;
  }

  /**
   * affiche case 0 à 9 inclus en bas du plateau
   */
  public void afficheBas() {
    System.out.print("|");
    for (int i = 10; i >= 0; i--) {
      listeCases.get(i).affiche();
      System.out.print("|");
    }
    System.out.println();
  }

  /**
   * affiche case 20 à 30 inclus en haut du plateau
   */
  public void afficheTop() {
    System.out.print("|");
    for (int i = 20; i <= 30; i++) {
      listeCases.get(i).affiche();
      System.out.print("|");
    }
    System.out.println();
  }

  public void affiche() {
    afficheTop();
    // 19 & 29
    int leftCase = 19;
    int rightCase = 29;

    for (int i = 0; i < 9; i++) {
      System.out.print("|");
      listeCases.get(leftCase).affiche();

      // 9 case vides du milieu
      for (int j = 0; j < 9; j++) {
        System.out.print("|");
        System.out.print(fixedLengthString("", 20));
      }
      System.out.print("|");
      listeCases.get(rightCase).affiche();
      System.out.println("|");

      leftCase--;
      rightCase++;
    }

    afficheBas();
  }

  public String fixedLengthString(String string, int length) {
    return String.format("%1$" + length + "s", string);
  }
}
