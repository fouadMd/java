package goosegame;

/**
 * The representation of WaitCell
 *
 * @author Medjahed Ainouch
 * @version 1.0
*/

public class WaitCell extends BasicCell {

	/*The number of turns to wait*/
	private int wait;
	/*The number of turns wait*/
	private int nb;

	/**
	*build a wait cell
	*@param index is the index of the cell
	*@param wait the numbers the player wait
	*/

	public WaitCell (int index,int wait){
		super(index);
		this.wait=wait;
	}

	/**
	*set a player at cell
	*@param player is the guy who plays
	*
	*/
	public void setplayer(Player player){
		this.player=player;
		this.nb=0;
	}

	/**
	*return if the player can play
	*@return true if he can play else false
	*/
	public boolean canPlay(){
		if(this.nb==this.wait){
			return true;
		}
		this.nb=this.nb+1;
		return false;
	}

	/**
	*return string object which contain effect of the cell
	*@return string object which contain effect of the cell
	*/
	public String StringEffect(){
		return "(wait for "+this.wait+" turns)";
	}
}
