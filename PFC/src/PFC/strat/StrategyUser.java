package PFC.strat;
import PFC.*;
import util.*;

/** 
 * The representation of Strategy
 *
 * @author Medjahed Fouad Aiouch Tarik
 * @version 26/03/2019
 */

public class StrategyUser implements Strategy{

	/**
	*return the move input by user
	*@return the move input by user
	*/
	public Move getMove(){
		pfcInput input = new pfcInput();
		System.out.println("Les trois coup sont designees respectivement par les lettres");
		System.out.println("r comme ROCK , p comme PAPER et s comme SCISSORS.");
		System.out.println("Pour effectuer un coup, il faut taper la lettre correspondante a votre coup");
		input.readInput();
		Move[] valeur = Move.values();
		return valeur[input.getMove()];
	}


}
