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
    return this.proprietaire.getPlateau().getNbCompany(this.proprietaire) * 4000;
  }

  @Override
  public String toString() {
    if (this.proprietaire == null) {
      return super.toString();
    }
    return super.toString() + ", loyer = " + this.getPrixLoyer() + "€";
  }

}
