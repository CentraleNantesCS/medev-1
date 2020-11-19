package edu.centralenantes.medev.tp1;

/**
 *
 * @author
 */
public class NoMoreMoney extends Exception{

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public NoMoreMoney(String errorMessage) {
        super(errorMessage);
    }

}
