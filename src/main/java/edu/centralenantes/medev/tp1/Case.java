package edu.centralenantes.medev.tp1;

/**
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
        System.out.print(fixedLengthString(this.toString(), Plateau.TEXT_LENGTH));
    }

    public String fixedLengthString(String s, int width) {
        int padSize = width - s.length();
        int padStart = s.length() + padSize / 2;

        s = String.format("%" + padStart + "s", s);
        s = String.format("%-" + width + "s", s);
        return s;
    }

    public int getPrix() {
        return 0;
    }
}
