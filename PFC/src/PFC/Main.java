package PFC;
import PFC.strat.*;
import java.lang.*;

/**
 * main of game
 *
 * @author Medjahed Fouad Aiouch Tarik
 * @version 26/03/2019
 */
public class Main{
    public static void main(String[] args) {
		Strategy stratuser=new StrategyUser();
		Player player1= new Player("user",stratuser);
		Strategy strat;
		switch(Integer.parseInt(args[0])){
			case 0 : strat=new Strategy0(); break;
			case 1 : strat=new Strategy1(); break;
			case 2 : strat=new Strategy2(); break;
			case 3 : strat=new Strategy3(); break;
			default : strat=new Strategy0();
		}
		Player player2= new Player("ordi",strat);
        Game newGame= new Game(10,player1,player2);
        newGame.play();
		newGame.affichage();
    }
}
