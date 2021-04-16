package PFC.strat;
import PFC.*;
/**
 * The representation of Strategy
 *
 * @author Medjahed Fouad Aiouch Tarik
 * @version 26/03/2019
 */
public class Strategy1 implements Strategy{

	/**
	*return the move PAPER
	*@return PAPER move
	*/
	public Move getMove(){
		return Move.PAPER;
	}
}
