package PFC.strat;
import PFC.*;
/**
 * The representation of Strategy
 *
 * @author Medjahed Fouad Aiouch Tarik
 * @version 26/03/2019
 */
public class Strategy3 implements Strategy{
	private boolean state;
	/**
	* Build the strategy
	*/
	public Strategy3(){
		this.state=false;
	}

	/**
	*return the move ROCK or SCISSORS
	*@return ROCK or SCISSORS move
	*/
	public Move getMove(){
		this.state=!this.state;
		if(this.state){
			return Move.ROCK;
		}
		return Move.SCISSORS;
	}
}
