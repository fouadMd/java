package battleship.util;
import battleship.io.*;
import java.io.IOException;
import battleship.util.*;

public class Game{


  //the state of the game
  private boolean finished;


  //the number of finished tour in a game
  private int tour;


  //the game Board
  private Sea GameTable;



  /** creates a game with given Sea
	 * @param sp1 the specified Sea
	 */
  public Game(Sea sp1){
    this.GameTable=sp1;
    this.finished=false;
    this.tour=0;
    }



  /** Return the gam board
   * @return the Game board
   */
  public Sea getTable(){
    return this.GameTable;
  }



  /** Return the tour
   * @return the index of tour
   */
  public int getTour(){
    return this.tour;
  }


  /** Return the state of the game
   * @return <code>true</code> if the game is finished,
   *   <code>false</code> if it isn't
   */
  public boolean isFinished(){
    return this.finished;
  }


  /** Ask the player for a position to attack by it coordonates
   */
  public void AskForAttack(){
    System.out.println("PLAYER MUST ATTACK");
    System.out.println("");
    System.out.println("Your opponent Sea");
    System.out.println("");
    this.GameTable.display(false);
    System.out.println("");
    System.out.println("Choose a line");
    int ligne = Input.readInt();
    System.out.println("");
    System.out.println("Choose a row");
    int colonne = Input.readInt();
    System.out.println("");
    System.out.println(this.GameTable.shoot(new Position(ligne,colonne)));
    System.out.println("");
    System.out.println("Your opponent Sea after your attack");
    this.GameTable.display(false);
    if (this.GameTable.getSeaLifePoints()==0){
      this.finished=true;
    }

    this.tour++;
    }



  /** Throw a battleship party for one oppenent player
   *    and print the number of tour he use to destroy all the ships
   */
  public void playGame(){
    while (this.isFinished()==false){
      this.AskForAttack();
    }
    System.out.println("");
    System.out.println("Game Finished in "+(this.getTour()+1)+" rounds.");
  }
}
