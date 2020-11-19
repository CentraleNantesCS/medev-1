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
  public int getPrixLoyer() {

    int a = 500;
    int b = 1600;

    if (this.proprietaire == null) {
      return 0;
    }
    return nbMaisons * a + nbHotels * b + 500;
  }

  public void construire() {
    if (nbMaisons < 3) {
      nbMaisons += 1;
      return;
    }
    nbHotels += 1;
    nbMaisons = 0;
  }

  @Override
  public String toString() {
    if (this.proprietaire == null) {
      return super.toString();
    }
    String ret = super.toString();
    if (nbMaisons > 0) {
      ret += ", " + nbMaisons + "maisons";
    }
    if (nbHotels > 0) {
      ret += ", " + nbHotels + "hotels";
    }
    return ret + ", loyer = " + this.getPrixLoyer() + "€";
  }

}