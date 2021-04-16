package PFC.strat;
import PFC.*;
import java.util.*;
/**
 * The representation of Strategy
 *
 * @author Medjahed Fouad Aiouch Tarik
 * @version 26/03/2019
 */
public class Strategy0 implements Strategy{

	/**
	*return random move
	*@return random move
	*/
	public Move getMove(){
		Random alea = new Random();
		Move[] valeur = Move.values();
		return valeur[alea.nextInt(valeur.length)];
	}


}
