package PFC;
/**
 * The representation of game
 *
 * @author Medjahed Fouad Aiouch Tarik
 * @version 26/03/2019
 */

public class Game{
	/* player one */
	private Player player1;
	/* player two */
	private Player player2;
	/* The number of round */
	private int nbround;
	/* the state of the game */
	private int state;

	/**
	* Build the game
	* @param round the number of round
	* @param player1 the first player
	* @param player2 the second player
	*/
	public Game(int round,Player player1, Player player2){
		this.nbround=round;
		this.player1=player1;
		this.player2=player2;
		this.state=1;
	}

	/**
	* Play one round
	*/
	private void playOnRound(){
		Move coupp1=this.player1.play();
		Move coupp2=this.player2.play();
		int comp=coupp1.compare(coupp2);
		if(comp>0){
			this.player1.addScore(1);
			this.affichageRound(coupp1,coupp2,1);
		}
		else if(comp<0){
			this.player2.addScore(1);
			this.affichageRound(coupp1,coupp2,2);
		}
		else{
			this.affichageRound(coupp1,coupp2,0);
		}
	}

	/**
	* Play the game
	*/
	public void play(){
		while(!isFinish()){
			this.playOnRound();
			this.state=this.state+1;
		}
	}

	/**
	* This function say if the game if finish
	*@return true if the game is finish false else
	*/
	private boolean isFinish(){
		return this.nbround+1==this.state;
	}

	/**
	* print the winner of the game and the score
	*/
	public void affichage(){
		if(this.player1.getScore()>this.player2.getScore()){
			System.out.println("The winner "+this.player1.getName()+" :"+this.player1.getScore()+"-"+this.player2.getScore());
		}
		else if(this.player1.getScore()==this.player2.getScore()){
			System.out.println("Equality :"+this.player1.getScore()+"-"+this.player2.getScore());
		}
		else{
			System.out.println("The winner is "+this.player2.getName()+" :"+this.player1.getScore()+"-"+this.player2.getScore());
		}
	}

	/**
	* print the round
	*@param coup1 the coup of the player 1
	*@param coup2 the coup of the player 2
	*@param winner the winner of the round 1 or 2 and if it is equality 0
	*/
	public void affichageRound(Move coup1,Move coup2,int winner){
		if(winner==1){
			System.out.println("Round "+this.state+": "+this.player1.getName()+" play "+coup1+" and "+this.player2.getName()+" play "+coup2+" "+this.player1.getName()+" win this round");
		}
		else if(winner==2){
			System.out.println("Round "+this.state+": "+this.player1.getName()+" play "+coup1+" and "+this.player2.getName()+" play "+coup2+" "+this.player2.getName()+" win this round");
		}
		else{
			System.out.println("Round "+this.state+": "+this.player1.getName()+" play "+coup1+" and "+this.player2.getName()+" play "+coup2+" equality");
		}
	}
}
