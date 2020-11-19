package edu.centralenantes.medev.tp1;

/**
 *
 * @author hayth
 */
public class Compagnie extends Achetable {

  public Compagnie(String nom, int prix) {
    super(nom, prix);
  }

  @Override
  public int getPrixLoyer() {

    if (this.proprietaire == null) {
      return 0;
    }
    // TODO
    return this.proprietaire.plateau.getNbCompagnies(this.proprietaire) * 4000;
  }

  @Override
  public String toString() {
    if (this.proprietaire == null) {
      return this.toString();
    }
    return this + ", loyer = " + this.getPrixLoyer() + "€";
  }

}
