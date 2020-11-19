package edu.centralenantes.medev.tp1;

import java.text.NumberFormat;

/**
 * @author
 */
public class Joueur {

  private String nom;
  private int fortune;
  private int position;
  private Plateau plateau;

  public Joueur() {
    this.nom = "";
    this.fortune = 100000;
    this.position = 0;
    this.plateau = new Plateau();
  }

  public Joueur(String name, int fortune, int pos, Plateau plat) {
    this.nom = name;
    this.fortune = fortune;
    this.position = pos;
    this.plateau = plat;
  }

  public void avance(int d) {
    if (this.position + d > 39) {
      this.position = this.position + d - 40;
    } else {
      this.position += d;
    }
  }

  public void paiement(Joueur j, int montant) throws NoMoreMoney {
    if (j == null) { // On paie la banque
      if (this.fortune < montant) {
        throw new NoMoreMoney("No more money. You're broke.");
      } else {
        this.fortune -= montant;
      }
    } else { // On paie un joueur
      if (this.fortune < montant) {
        // Exception NoMoreMoney ?
        throw new NoMoreMoney("No more money. You're broke.");
      } else {
        j.setFortune(j.getFortune() + montant);
        this.fortune -= montant;
      }
    }
  }

  public static int lanceLeDe() {
    return ((int) Math.floor(Math.random() * 6)) + 1;
  }

  public void monTourDeJeu() { // Classe Joueur
    int valeur = lanceLeDe();
    this.avance(valeur);
    Case caseCourante = this.plateau.getListeCases().get(this.position);
    System.out.printf("Le joueur %s se trouve sur la case %s -- Fortune: %s € \n", this.nom, caseCourante.getNom(), NumberFormat.getInstance().format(this.fortune));

    if (caseCourante instanceof Achetable) { // Case achetable
      if (((Achetable) caseCourante).getProprietaire() == null) { // Cas où la case n'appartient pas encore à un joueur
        if (((Achetable) caseCourante).getPrix() < this.fortune && valeur % 2 == 1) { // Le joueur l'achète si la valeur
          ((Achetable) caseCourante).acheter(this);
        }
      } else {
        // Cas où la case appartient à un joueur
        if (((Achetable) caseCourante).getProprietaire() == this && caseCourante instanceof Constructible) {
          // Notre case
          ((Constructible) caseCourante).construire();
        } else {
          // La case d'un autre joueur
          try {
            this.paiement(((Achetable) caseCourante).getProprietaire(), ((Achetable) caseCourante).getPrixLoyer());
          } catch (Exception e) {
            // No money :')
            System.out.println(this.nom + ":" + e.getMessage());
            try {
              this.paiement(((Achetable) caseCourante).getProprietaire(),
                      Math.min(((Achetable) caseCourante).getPrixLoyer(), this.fortune));
            } catch (NoMoreMoney e1) {
              // TODO Auto-generated catch block
              e1.printStackTrace();
            }

          }
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

  @Override
  public String toString() {
    return this.nom;
  }

}
