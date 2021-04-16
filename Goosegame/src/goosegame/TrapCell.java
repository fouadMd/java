package goosegame;
/**
 * The representation of TrapCell
 *
 * @author Medjahed Ainouch
 * @version 1.0
*/

public class TrapCell extends BasicCell {

	/**
	*build a trap cell
	*@param index is the index of the cell
	*/
	public TrapCell (int index){
		super(index);
	}

	/**
	*return if the player can play
	*@return true if he can play else false
	*/
	public boolean canPlay(){
		return false;
	}

	/**
	*return string object which contain effect of the cell
	*@return string object which contain effect of the cell
	*/
	public String StringEffect(){
		return "(trap)";
	}
}
