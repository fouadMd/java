package goosegame;

import java.util.*;

/**
 * The representation of StartCell
 *
 * @author Medjahed Ainouch
 * @version 1.0
*/

public class StartCell implements Cell {

	/*the players in the cell*/
	protected List<Player> thePlayers;
	/*the index of the cell*/
	private int index;

	/**
	*build a StartCell
	*@param index is the index of the cell
	*/
	public StartCell (int index){
		this.index=index;
		this.thePlayers=new ArrayList<Player>();
	}

	/**
	*set a player at cell
	*@param player is the guy who plays
	*
	*/
	public void setplayer(Player player){
		this.thePlayers.add(player);
	}


	/**
	*get the first player in the cell
	*@return return the Player in the cell
	*/
	public Player getPlayer(){
		return this.thePlayers.get(0);
	}


	/**
	*return True if a player is in the cell else False
	*@return True if a player is in the cell else False
	*/
	public boolean isBusy(){
		if(this.thePlayers.size()==0){
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
	*apply effect of cell
	*@param resultdice is the result of the methode twoDiceThrows
	*@return the index of the cell after the effect of the cell
	*/
	public int Effect(int resultdice){
		return this.getIndex();
	}

	/**
	*remove the player
	*@param p the player in the cell who you want remove
	*/
	public void remove (Player p){
		this.thePlayers.remove(this.thePlayers.indexOf(p));
	}
	/**
	*return if the player can play
	*@return true if he can play else false
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
