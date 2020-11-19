package edu.centralenantes.medev.tp1;

/**
 *
 * @author hayth
 */
public abstract class Case {

  public String nom;

  public Case(String nom) {
    this.nom = nom;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  @Override
  public String toString() {
    String ret = this.nom;

    return ret;
  }

  public void affiche() {
    System.out.println(this);
  }

public int getPrix() {
	return 0;
}
}
