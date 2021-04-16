package goosegame;

/**
 * The representation of BasicCell
 *
 * @author Medjahed Ainouch
 * @version 1.0
*/

public class BasicCell implements Cell {

	/*the player*/
	protected Player player;
	/*the index of the cell*/
	protected int index;

	/**
	*build a basic cell
	*@param index is the index of the cell
	*/
	public BasicCell (int index){
		this.index=index;
		this.player=null;
	}

	/**
	*set a player at cell
	*@param player is the guy who plays .
	*
	*/
	public void setplayer(Player player){
		this.player=player;
	}


	/**
	*get the player in the cell
	*@return return the Player in the cell
	*/
	public Player getPlayer(){
		return this.player;
	}


	/**
	*return True if a player is in the cell else False
	*@return True if a player is in the cell else False
	*/
	public boolean isBusy(){
		if(this.player==null){
			return false;
		}
		return true;
	}

	/**
	*get the index of cell
	*@return the index of cell
	*/
	public int getIndex() {
		return this.index;
	}

	/**
	*apply effect to cell
	*@param resultdice is the result of the methode twoDiceThrows
	*@return the index of the cell after the effect of the cell
	*/
	public int Effect(int resultdice){
		return this.getIndex();
	}

	/**
	* remove the player
	* @param p the player in the cell who you want remove
	*/
	public void remove (Player p){
		this.player=null;
	}

	/**
	*return if the player can play
	*@return true if he can play false else
	*/
	public boolean canPlay(){
		return true;
	}

	/**
	*return string object which contain effect of the cell
	*@return string object which contain effect of the cell
	*/
	public String StringEffect(){
		return "";
	}
}
