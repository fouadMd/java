package PFC;
import PFC.strat.*;
/**
 * The representation of player
 *
 * @author Medjahed Fouad Aiouch Tarik
 * @version 26/03/2019
 */

public class Player{
	/* The name of Player */
	private String name;
	/* The score of player */
	private int score;
	/* The strategy of the Player */
	private Strategy strat;

	/**
	* Build the Player
	* @param name of the Player
	* @param strat the strategy of the Player
	*/
	public Player(String name,Strategy strat){
		this.name=name;
		this.score=0;
		this.strat=strat;
	}

	/**
	*return move of player
	*@return move of player
	*/
	public Move play(){
		return this.strat.getMove();
	}
	/**
	* Return the score of the Player
	* @return the score of the Player
	*/
	public int getScore(){
		return this.score;
	}

	/**
	* Return the name of the Player
	* @return the name of the Player
	*/
	public String getName(){
		return this.name;
	}

	/**
	* Add the number to Player's score
	* @param n the number to add
	*/
	public void addScore(int n){
		this.score=this.score+n;
	}

	/**
	* @return a string representation of player
	*/
	public String toString() {
		return "The score of the player "+this.name+" is "+this.score;
	}

}
