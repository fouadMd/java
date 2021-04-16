package goosegame;

/**
 * The representation of JumpCell
 *
 * @author Medjahed Ainouch
 * @version 1.0
*/

public class JumpCell extends BasicCell {

	/*the index of the cell where the cell will jump*/
	private int end;

	/**
	*build a jump cell
	*@param index is the index of the cell
	*@param end is the index of the cell where the cell will jump
	*/
	public JumpCell (int index,int end){
		super(index);
		this.end=end;
	}

	/**
	*apply effect of cell
	*@param resultdice is the result of the methode twoDiceThrows
	*@return the index of the cell after the effect of the cell
	*/
	public int Effect(int resultdice){
		return this.end;
	}

	/**
	*return string object which contain effect of the cell
	*@return string object which contain effect of the cell
	*/
	public String StringEffect(){
		return "(teleport to "+this.end+")";
	}
}
