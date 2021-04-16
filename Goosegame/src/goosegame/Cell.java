package goosegame;

/**
 * The representation of Cell
 *
 * @author Medjahed Ainouch
 * @version 1.0
*/

public interface Cell {
	/**
	*set a player at cell
	*@param player is the guy who plays .
	*
	*/
    public void setplayer(Player player);

    /**
    *get the player in the cell
    *@return return the Player in the cell
    */
    public Player getPlayer();

    /**
    *return True if a player is in the cell else False
    *@return True if a player is in the cell else False
    */
    public boolean isBusy();

    /**
    *get the index of cell
    *@return the index of cell
    */
    public int getIndex();

    /**
    *apply effect to cell
	*@param resultdice is the result of the methode twoDiceThrows
	*@return the index of the cell after the effect of the cell
    */
    public int Effect(int resultdice);

	/**
	* remove the player
	* @param p the player in the cell who you want remove
	*/
	public void remove (Player p);

	/**
	*return if the player can play
	*@return true if he can play else false
	*/
	public boolean canPlay();

	/**
	*return string object which contain effect of the cell
	*@return string object which contain effect of the cell
	*/
	public String StringEffect();
}
